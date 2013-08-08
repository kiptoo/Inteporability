package com.springapp.mvc;

import com.springapp.mvc.db.javaconnect;
import com.springapp.mvc.syncmodel.SyncDataElement;
import com.springapp.mvc.syncmodel.SyncDataSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
     private DataSetRepository dataSet;
    String  tablelement="" +
        "CREATE TABLE  IF NOT EXISTS `dataelement`(\n" +
        "   `id` int(11)  AUTO_INCREMENT,\n" +
        "  `dataset_id` Varchar(110),\n" +
        "  `name` Varchar(110) ,\n" +
        "  `dataelement_id` Varchar(110) ,\n" +
        "  `concept_id` Varchar(110) ,\n" +
        "  `value` Varchar(110) ,\n" +
        "  PRIMARY KEY (`id`)\n" +
        ") \n"  ;
    String tabledataset="" +
            "CREATE TABLE  IF NOT EXISTS `dataset` (\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `set_id` varchar(110) DEFAULT NULL,\n" +
            "  `name` varchar(110) DEFAULT NULL,\n" +
            "  `period` varchar(110) DEFAULT NULL,\n" +
            "  `orgunit` varchar(110) DEFAULT NULL,\n" +
            "  `complete_date` varchar(110) DEFAULT NULL,\n" +
            " `code` varchar(110) DEFAULT NULL,"+
            "  PRIMARY KEY (`id`)\n" +
            ") ";

    User user=new User();
    ResultSet rs=null;
    List<SyncDataSet> dataSets;
    List<SyncDataElement> dataElem;
    Connection conn= javaconnect.connecrDb();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Add(ModelMap model) {
        model.addAttribute("user",user);
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (User user : userRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getId());
            userJSON.put("username", user.getUsername());
            userJSON.put("password", user.getPassword());

            userArray.put(userJSON);
        }
        return userArray.toString();
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void send() {

    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {

        userRepository.save(user);
     /*    String Sql="INSERT INTO dataset(set_id,name,code,period) values(?,?,?,?)";
        String Sql1="INSERT INTO dataelement(dataset_id,name,dataelement_id) values(?,?,?)";
        getall get =new  getall();
        try {
            System.out.println("Sending GET request");
            dataSets =get.send(user.getUsername(),user.getPassword(),user.getUrl());

            PreparedStatement pstmt = conn.prepareStatement(tabledataset);
            PreparedStatement dataelem = conn.prepareStatement(tablelement);
            pstmt.execute();
            dataelem.execute();
            for(SyncDataSet d: dataSets){

                PreparedStatement add = conn.prepareStatement(Sql);
               add.setString(1,d.getId());
                add.setString(2,d.getName());
                add.setString(3,d.getCode());
                add.setString(4,d.getPeriod());
                add.executeUpdate();
                dataElem= get.dataelem(user.getUsername(), user.getPassword(), d.getHref());
                for(SyncDataElement e: dataElem){
                    PreparedStatement dataelemnt = conn.prepareStatement(Sql1);
                    dataelemnt.setString(1,d.getId());
                    dataelemnt.setString(2,e.getName());
                    dataelemnt.setString(3,e.getId());

                    dataelemnt.executeUpdate();
                }
               System.out.println("Added to database fully");
            }

        } catch (Exception e) {
            System.out.println("Cannot Send");
            e.printStackTrace();

        }
     try {
            HttpClientExample dhis=new HttpClientExample();
            dhis.sendGet( user.getUsername(), user.getPassword(), user.getUrl());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } */
        return "redirect:/";
    }

    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {

        userRepository.delete(userRepository.findOne(userId));

        return "redirect:/";
    }
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public
    @ResponseBody
    String listdataSets(ModelMap model) throws JSONException {

        JSONArray userArray = new JSONArray();
      /*  for (SyncDataSet dat :datasetRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("name", dat.getName());

            userArray.put(userJSON);
        }   */
        return userArray.toString();
    }
}