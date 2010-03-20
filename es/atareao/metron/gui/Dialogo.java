/*
 * Dialogo
 *
 * File created on 07-mar-2010
 * Copyright (c) 2009 Lorenzo Carbonell
 * email: lorenzo.carbonell.cerezo@gmail.com
 * website: http://www.atareao.es
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.atareao.metron.gui;

/**
 *
 * @author atareao
 */
public interface Dialogo {
    int OP_ADD = 0;
    int OP_DELETE = 2;
    int OP_EDIT = 1;
    int OP_VIEW = 3;
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    int RET_OK = 1;

    int getReturnStatus();

    void setReturnStatus(int returnStatus);

}
