/**
 * Created by Sarthak on 10-09-2017.
 */

public class BackgroundWorker extends AsyncTask<void,void,void>{
    Context context;
    BackgroundWorker (Context ctx){
        context=ctx;
    }
@Override
    protected void doInBackground(Void... params)
    {
        return null;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    protected void OnPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
    }

    protected void OnProgressiveUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }

}

