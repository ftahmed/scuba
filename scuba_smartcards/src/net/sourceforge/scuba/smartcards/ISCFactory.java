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

public interface ISCFactory<C,R>  {

	ICommandAPDU createAccessorC(C c);

	IResponseAPDU createAccessorR(R c);

	C createCommandAPDU( int cla, int ins, int p1, int p2, byte[] data, int ne );

	C createCommandAPDU(int cla, int ins, int p1, int p2, byte[] data);

	C createCommandAPDU (int cla, int ins, int p1, int p2, int ne);

	R createResponseAPDU(byte[] bytes);	
}
