package com.springapp.mvc;

import com.springapp.mvc.syncmodel.SyncDataSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: kip
 * Date: 7/30/13
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataSetController {
    @Autowired
    private DataSetRepository dataset;
   DataSetController user=new DataSetController();
    @RequestMapping(value = "/dataSet", method = RequestMethod.GET)
    public String Add(ModelMap model) {
        model.addAttribute("dataSet",user);
        model.addAttribute("Interface", dataset.findAll());
        return "dataSets";
    }
    @RequestMapping(value = "/dataSets", method = RequestMethod.GET)
    public
    @ResponseBody
    String listdataSets(ModelMap model) throws JSONException {

        JSONArray userArray = new JSONArray();
        for (SyncDataSet data : dataset.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("name", data.getName());

            userArray.put(userJSON);
        }
        return userArray.toString();
    }
    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public String add(@ModelAttribute("dataset") SyncDataSet user, BindingResult result) {

       dataset.save(user);
        return "redirect:/dataSets";
    }
    }
