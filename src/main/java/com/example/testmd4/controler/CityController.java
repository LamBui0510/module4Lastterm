package com.example.testmd4.controler;

import com.example.testmd4.model.City;
import com.example.testmd4.model.Country;
import com.example.testmd4.service.CityService;
import com.example.testmd4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    CityService cityService;
    @Autowired
    CountryService countryService;
   @ModelAttribute("city")
    public City getCity(){
       return new City();
   }
   @GetMapping("/city")
    public ModelAndView showAll(@RequestParam (defaultValue = "0") int page){
       ModelAndView modelAndView = new ModelAndView("show");
       modelAndView.addObject("city",cityService.findAll(PageRequest.of(page,2)));
        return modelAndView;
   }
   @ModelAttribute("country")
    public List<Country> showCountry(){
       return countryService.findAll();
   }
    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("createCity");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("create")
    public Object add(@Valid @ModelAttribute(value = "city") City city, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("createCity");
            return modelAndView;
        }
        else {
            cityService.save(city);
            return "redirect:/city";
        }
    }
    @GetMapping("edit")
    public ModelAndView edit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("editCity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("edit")
    public String editUser(@Valid @ModelAttribute(value = "city") City city, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()){
            return "redirect:/editCity";
        }
        else {
        cityService.save(city);
        return "redirect:/city";
    }
   }

    @GetMapping("/delete")
    public ModelAndView deleteCity(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("deleteCity");
        modelAndView.addObject("city", cityService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        cityService.delete(id);
        return "redirect:/city";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam (value = "search") String search,@RequestParam (defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("city", cityService.findUsersByName(search,PageRequest.of(page,2)));
        return modelAndView;
    }
    @GetMapping ("detail")
    public ModelAndView detail(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("cityDetail");
        modelAndView.addObject("city" , cityService.findById(id));
        return modelAndView;
    }

}
