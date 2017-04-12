package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import models.*;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.data.*;
import play.mvc.*;

import views.html.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	@Inject
	private JPAApi api;
	
    public Result index() {
        return ok(index.render("Test"));
    }

	@Transactional
	public Result addLocation() {
		EntityManager em = api.em();
		String name = formFactory.form().bindFromRequest().get("name");
		List<Location> locations = em.createQuery(
				"select l from Location l where l.name LIKE :custName", Location.class)
				.setParameter("custName", name)
				.getResultList();
		if(locations.size() == 0) {
			Location l = new Location(name);
			em.persist(l);
			return ok(Json.toJson(l));
		} else {
			ObjectNode result = Json.newObject();
			result.put("error", "Location already exists");
			return status(400, result);
		}
	}

	@Transactional
	public Result addCategory() {
		EntityManager em = api.em();
		String name = formFactory.form().bindFromRequest().get("name");
		List<Category> categories = em.createQuery(
				"select c from Category c where c.name LIKE :custName", Category.class)
				.setParameter("custName", name)
				.getResultList();
		if(categories.size() == 0) {
			Category c = new Category(name);
			em.persist(c);
			return ok(Json.toJson(c));
		} else {
			ObjectNode result = Json.newObject();
			result.put("error", "Category already exists");
			return status(400, result);
		}
	}

	@Transactional
	public Result addRestaurant() {
		EntityManager em = api.em();
		String name = formFactory.form().bindFromRequest().get("restaurantName");
		List<Restaurant> restaurants =	em.createQuery(
				"select r from Restaurant r where r.restaurantName LIKE :custName", Restaurant.class)
				.setParameter("custName", name)
				.getResultList();
		if(restaurants.size() == 0) {
			Restaurant r = formFactory.form(Restaurant.class).bindFromRequest().get();
			em.persist(r);
			return ok(Json.toJson(r));
		} else {
			ObjectNode result = Json.newObject();
			result.put("error", "Restaurant already exists");
			return status(400, result);
		}
	}

	@Transactional
	public Result getLocations() {
		EntityManager em = api.em();
		String query = "select l from Location l ";
		List<Location> locations = em.createQuery(query, Location.class).getResultList();
		return ok(Json.toJson(locations));
	}

	@Transactional
	public Result getLocationById(Long id) {
		EntityManager em = api.em();
		Location location = em.find(Location.class, id);
		return ok(Json.toJson(location));
	}
}
