package com.ejemplo.instagram.dao;

import android.os.AsyncTask;

import com.ejemplo.instagram.model.Post;
import com.ejemplo.instagram.model.PostContainer;
import com.google.gson.Gson;

import java.util.List;

import util.DAOException;
import util.HTTPConnectionManager;
import util.ResultListener;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class InstagramDAO {


    private String userName;

    public InstagramDAO(String userName) {
        this.userName = userName;
    }

    //ESTE METODO CREA LA TAREA ASINCRONA Y PIDE UNA LISTA DE PRODUCTOS
    public void getAllPost(final ResultListener<List<Post>> listener) {
        RetrievePostTask retrievePostTask = new RetrievePostTask(listener);
        retrievePostTask.execute();
    }

    //ESTA CLASE ES UNA CLASE QUE ME PERMITE GENERAR UNA TAREA ASINCRONICA. ES DECIR, ESTA TAREA SE EJECUTARA
// INDEPENDIENTEMENTE DE LO QUE ESTE HACIENDO COMO ACTIVIDAD PRINCIPAL
    class RetrievePostTask extends AsyncTask<String, Void, List<Post>> {

        private ResultListener<List<Post>> listener;

        public RetrievePostTask(ResultListener<List<Post>> listener) {
            this.listener = listener;
        }

        //Esto método se ejecuta mientras sigue corriendo la tarea principal. Aqui lo que haremos es conectarnos
        // al servicio y descargar la lista.
        @Override
        protected List<Post> doInBackground(String... params) {

            HTTPConnectionManager connectionManager = new HTTPConnectionManager();
            String input = null;

            try {
                input = connectionManager.getRequestString("https://www.instagram.com/"+ userName +"/media/");
            } catch (DAOException e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            PostContainer items = gson.fromJson(input, PostContainer.class);

            return items.getPosts();
        }

        //Una vez terminado el procesamiento, le avisamos al listener que ya tiene la lista disponible.
        @Override
        protected void onPostExecute(List<Post> postList) {

            this.listener.finish(postList);
        }
    }
}




















