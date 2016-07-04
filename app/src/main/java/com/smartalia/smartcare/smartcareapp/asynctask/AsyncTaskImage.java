package com.smartalia.smartcare.smartcareapp.asynctask;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by nicola on 02/07/16.
 */
public class AsyncTaskImage {
        /** The system calls this to perform work in a worker thread and
         * delivers it the parameters given to AsyncTask.execute() */

       private ImageView imageView;

       /* protected Bitmap doInBackground(String... urls) {
            return loadImageFromNetwork(urls[0]);
        }
*/

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}

