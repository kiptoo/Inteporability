package com.springapp.mvc.syncmodel;

import com.springapp.mvc.dhis.HttpClientExample;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kip
 * Date: 7/29/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class getall {

    HttpClientExample dhis=new HttpClientExample();


  public static void main(String []args)throws Exception{
    /*  String  tablelement="" +
              "CREATE TABLE  IF NOT EXISTS `dataelement`(\n" +
              "   `id` int(11)  AUTO_INCREMENT,\n" +
              "  `dataset_id` Varchar(110),\n" +
              "  `name` Varchar(110) ,\n" +
              "  `dataelement_id` Varchar(110) ,\n" +
              "  `concept_id` Varchar(110) ,\n" +
              "  `aggValue` int(11) ,\n" +
              "  PRIMARY KEY (`id`)\n" +
              ") \n"  ;
      String tabledataset="" +
              "CREATE TABLE IF NOT EXISTS `dataset` (\n" +
              "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
              "  `dataset_id` varchar(110) DEFAULT NULL,\n" +
              "  `name` varchar(110) DEFAULT NULL,\n" +
              "  `period` varchar(110) DEFAULT NULL,\n" +
              "  `orgunit` varchar(110) DEFAULT NULL,\n" +
              "  `complete_date` varchar(110) DEFAULT NULL,\n" +
              "  PRIMARY KEY (`id`)\n" +
              ") ";

      ResultSet rs=null;
      List<SyncDataSet> dataSets;

      try {
          Connection conn= javaconnect.connecrDb();
          PreparedStatement pstmt = conn.prepareStatement(tabledataset);
          PreparedStatement dataelem = conn.prepareStatement(tablelement);

          pstmt.execute();
          dataelem.execute();
      } catch (SQLException e) {
          e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }    */

  }
    public List<SyncDataSet> send (String Username,String pass,String Url) throws Exception{

     /*   user.setUsername("admin");
        user.setPassword("district");
        user.setUrl("http://localhost:8090/dhis");   */
        String username=Username;
        String password=pass;
        String url=Url;
        List<SyncDataSet> readDEG=new ArrayList<SyncDataSet>();
        String OpenmrsdeURL = "";
            if(!username.equals("")&&!password.equals("")){
        String datasets= dhis.sendGet( username,password, url+"/api/dataSets.xml");
                InputStream stream = new ByteArrayInputStream(  datasets.getBytes( "UTF-8" ) );
                System.out.println( datasets);
                StaXParser read = new StaXParser();

               readDEG = read.readConfig(stream);

                System.out.println("Total DataSets......."+"\n" );

                for ( SyncDataSet item : readDEG )
                {


                    System.out.println( item.getName());

                    //Search for "openmrsde" dataelement group
                   /* if ( item.getId().equals( "UpS2bTVcClZ" ) ){
                        OpenmrsdeURL = item.getHref();
                        dataelem(OpenmrsdeURL);

                    }  */
                }
                System.out.println("Total DataSets:="+readDEG.size());
            }
        else{

                System.out.println("Username or password missing");
            }

        return  readDEG;
    }
    public List<SyncDataElement> dataelem (String Username,String pass,String Url) throws Exception{
        String username=Username;
        String password=pass;
        String url=Url;
        String dataelements= dhis.sendGet( username,password, url);
        InputStream stream = new ByteArrayInputStream(dataelements.getBytes( "UTF-8" ) );
        System.out.println(dataelements);
        StaXParser read = new StaXParser();
        List<SyncDataElement> readELEM = read.readDe(stream);
        System.out.println("Total DataElements......."+"\n" );
        for ( SyncDataElement item : readELEM )
        {
            //Search for "openmrsde" dataelement group

           // String OpenmrsdeURL = item.getHref();
           // dataelem(OpenmrsdeURL);
            System.out.println( item.getName());


        }

        System.out.println("Total DataElements="+readELEM.size());
        return readELEM;
    }
}
