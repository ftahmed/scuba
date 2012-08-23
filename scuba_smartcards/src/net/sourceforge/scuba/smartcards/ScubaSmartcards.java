/*
 * SCUBA smart card framework.
 *
 * Copyright (C) 2012  The SCUBA team.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id: $
 */

package net.sourceforge.scuba.smartcards;

public class ScubaSmartcards<C, R> 
{
	private static ScubaSmartcards<?, ?> instance;

	private ISCFactory<C, R> factory;

	public void init(ISCFactory<C, R> fac) {
		this.factory = fac;
	}

	@SuppressWarnings("unchecked")
	public static <C, R> ScubaSmartcards<C, R> getInstance() {
		if( instance == null ) {
			instance = new ScubaSmartcards<C, R>();
		}
		return (ScubaSmartcards<C, R>)instance;
	}

	public C createCommandAPDU(int cla, int ins, int p1, int p2, byte[] data, int ne) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createCommandAPDU(cla, ins, p1, p2, data, ne);
	}

	public C createCommandAPDU(int cla, int ins, int p1, int p2, byte[] data) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createCommandAPDU(cla, ins, p1, p2, data);
	}

	public C createCommandAPDU (int cla, int ins, int p1, int p2, int ne) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createCommandAPDU(cla, ins, p1, p2, ne);
	}

	public ICommandAPDU accessC(C c) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createAccessorC(c);
	}

	public IResponseAPDU accessR(R r) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createAccessorR(r);
	}

	public R createResponseAPDU(byte[] bytes) {
		if (factory == null) { throw new IllegalStateException("ScubaSmartcards has not been initialized yet!"); }
		return factory.createResponseAPDU(bytes);
	}
}