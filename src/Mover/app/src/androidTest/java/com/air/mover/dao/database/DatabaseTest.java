package com.air.mover.dao.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.rule.ActivityTestRule;

import com.air.mover.dao.model.Parada;
import com.air.mover.view.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Javier on 23/11/2017.
 */
public class DatabaseTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /*
    Test que comprueba que el metodo getCommentParada(), al pasarle un nombre y un id de una parada
     devuelve el string de cometarios asociado a ésta.
     */
    @Test
    public void U12A() throws Exception {
        try {
            Database.DBHelper dbHelper = new Database.DBHelper(mActivityTestRule.getActivity().getApplicationContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Database.ParadasTable.COLUMN_ID, 463);
            values.put(Database.ParadasTable.COLUMN_PARADA_NAME, "La Pereda");
            values.put(Database.ParadasTable.COLUMN_COMMENT, "Cerca de un buen restaurante");
            db.insert(Database.ParadasTable.TABLE_NAME, null, values);

            Parada p = Database.getCommentParada(463, "La Pereda", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertNotNull(p.getComentarios());

        } catch (Exception e) {
            Assert.fail("El comentario debería ser: Cerca de un buen restaurante");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que el metodo getCommentParada(), al pasarle un nombre y un id de una parada
    devuelve el string de cometarios vacio asociado a ésta.
    */
    @Test
    public void U12B() throws Exception {
        try {
            Database.DBHelper dbHelper = new Database.DBHelper(mActivityTestRule.getActivity().getApplicationContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(Database.ParadasTable.COLUMN_ID, 499);
            values.put(Database.ParadasTable.COLUMN_PARADA_NAME, "Camarreal Peñacastillo");
            values.put(Database.ParadasTable.COLUMN_COMMENT, "");
            db.insert(Database.ParadasTable.TABLE_NAME, null, values);

            Parada p = Database.getCommentParada(499, "Camarreal Peñacastillo", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertNotNull(p.getComentarios());
        } catch (Exception e) {
            Assert.fail("El comentario debería estar vacío");
            e.printStackTrace();

        }
    }

    /*
    Test que comprueba que no se puede obtener el string de comentarios
     de una parada inexistente pasandole al metodo un nombre e id erroneos.
     */
    @Test
    public void U12C() throws Exception {
        try {
            Parada p = Database.getCommentParada(5, "Unican", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals(null, p.getNombre());

        } catch (Exception e) {
            Assert.fail("La parada  no deberia existir");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que no se puede obtener el string de comentarios
    de una parada inexistente pasandole al metodo un nombre correcto pero un id erroneo
     */
    @Test
    public void U12D() throws Exception {
        try {

            Parada p = Database.getCommentParada(1, "La Pereda", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals(null, p.getNombre());

        } catch (Exception e) {
            Assert.fail("La parada  no deberia existir");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que se puede añadir un comentario a una parada existente
     */
    @Test
    public void U13A() throws Exception {
        try {
            Database.addComment(463, "La Pereda", "Cerca de un buen restaurante", mActivityTestRule.getActivity().getApplicationContext());
            Parada p = Database.getCommentParada(463, "La Pereda", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals("Cerca de un buen restaurante", p.getComentarios());
        } catch (Exception e) {
            Assert.fail("El comentario deberia coincidir");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que se pueden actualizar los comentarios de una parada existente
    */
    @Test
    public void U13B() throws Exception {
        try {
            Database.addComment(463, "La Pereda", "Cerca de un buen restaurante que cerró", mActivityTestRule.getActivity().getApplicationContext());
            Parada p = Database.getCommentParada(463, "La Pereda", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals("Cerca de un buen restaurante que cerró", p.getComentarios());

        } catch (Exception e) {
            Assert.fail("El comentario deberia coincidir");
            e.printStackTrace();

        }
    }

    /*
    Test que comprueba que se puede añadir un comentario vacio a una parada existente
     */
    @Test
    public void U13C() throws Exception {
        try {
            Database.addComment(499, "Camarreal Peñacastillo", "", mActivityTestRule.getActivity().getApplicationContext());
            Parada p = Database.getCommentParada(499, "Camarreal Peñacastillo", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals("", p.getComentarios());

        } catch (Exception e) {
            Assert.fail("El comentario deberia coincidir");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que se puede añadir un comentario con caracter conflictivo a una parada existente.
     */
    @Test
    public void U13D() throws Exception {
        try {
            Database.addComment(499, "Camarreal Peñacastillo", "Junto al parque de la araña", mActivityTestRule.getActivity().getApplicationContext());
            Parada p = Database.getCommentParada(499, "Camarreal Peñacastillo", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals("Junto al parque de la araña", p.getComentarios());

        } catch (Exception e) {
            Assert.fail("El comentario deberia coincidir");
            e.printStackTrace();
        }
    }

    /*
    Test que comprueba que se puede añadir un comnetario vacio a una parada con comentario.
     */
    @Test
    public void U13E() throws Exception {
        try {
            Database.addComment(463, "La Pereda", "Cerca de un buen restaurante que cerró", mActivityTestRule.getActivity().getApplicationContext());
            Database.addComment(463, "La Pereda", "", mActivityTestRule.getActivity().getApplicationContext());
            Parada p = Database.getCommentParada(463, "LaPereda", mActivityTestRule.getActivity().getApplicationContext());

            Assert.assertEquals("", p.getComentarios());

        } catch (Exception e) {
            Assert.fail("El comentario deberia coincidir");
            e.printStackTrace();
        }

    }

}