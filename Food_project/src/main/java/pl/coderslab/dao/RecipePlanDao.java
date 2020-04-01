package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Admins;
import pl.coderslab.model.DashboardView;
import pl.coderslab.model.RecipePlan;
import pl.coderslab.utils.DbUtil;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipePlanDao {

    private static final String CREATE_RECIPE_PLAN_QUERY = "INSERT INTO recipe_plan(id, recipe_id, meal_name, display_order, day_name_id, plan_id) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_RECIPE_PLAN_QUERY = "DELETE FROM recipe_plan WHERE id = ?;";
    private static final String FIND_ALL_RECIPE_PLAN_QUERY = "SELECT * FROM  recipe_plan;";
    private static final String READ_RECIPE_PLAN_QUERY = "SELECT * FROM recipe_plan WHERE id = ?;";
    private static final String UPDATE_RECIPE_PLAN_QUERY = "UPDATE recipe_plan SET  first_name = ? , last_name = ? , email = ? , password = ? , superadmin = ? , enable = ? WHERE id = ?;";
    private static final String DASHBOARD_RECIPE_PLAN_QUERY = "SELECT  p.name,dn.name, meal_name, r.description, r.id\n" +
            "FROM recipe_plan\n" +
            "         JOIN plan p on recipe_plan.plan_id = p.id\n" +
            "JOIN day_name dn on recipe_plan.day_name_id = dn.id\n" +
            "JOIN recipe r on recipe_plan.recipe_id = r.id\n" +
            "WHERE p.admin_id = ? AND plan_id= ?;";

    public RecipePlan read(Integer recipeId) {
        RecipePlan recipePlan = new RecipePlan();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_RECIPE_PLAN_QUERY)
        ) {
            statement.setInt(1, recipeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    recipePlan.setId(resultSet.getInt("id"));
                    recipePlan.setMealName(resultSet.getString("meal_name"));
                    recipePlan.setRecipeId(resultSet.getInt("recipe_id"));
                    recipePlan.setDisplayOrder(resultSet.getInt("display_order"));
                    recipePlan.setDayNameId(resultSet.getInt("day_name_id"));
                    recipePlan.setPlanId(resultSet.getInt("plan_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipePlan;
    }

    public List<RecipePlan> findAll() {
        List<RecipePlan> recipePlans = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_RECIPE_PLAN_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                RecipePlan recipePlanToAdd = new RecipePlan();
                recipePlanToAdd.setId(resultSet.getInt("id"));
                recipePlanToAdd.setDayNameId(resultSet.getInt("day_name_id"));
                recipePlanToAdd.setDisplayOrder(resultSet.getInt("display_order"));
                recipePlanToAdd.setPlanId(resultSet.getInt("plan_id"));
                recipePlanToAdd.setRecipeId(resultSet.getInt("recipe_id"));
                recipePlanToAdd.setMealName(resultSet.getString("meal_name"));
                recipePlans.add(recipePlanToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipePlans;

    }

    public List<DashboardView> dashboardRecipePlan(Integer adminId, Integer planId) {
        List<DashboardView> recipePlans = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DASHBOARD_RECIPE_PLAN_QUERY)
        ) {
            statement.setInt(1, adminId);
            statement.setInt(2, planId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DashboardView recipePlanToAdd = new DashboardView();
                    recipePlanToAdd.setPlanName(resultSet.getString("p.name"));
                    recipePlanToAdd.setDayName(resultSet.getString("dn.name"));
                    recipePlanToAdd.setMealName(resultSet.getString("meal_name"));
                     recipePlanToAdd.setDescription(resultSet.getString("description"));
                    recipePlanToAdd.setRecipeId(resultSet.getInt("id"));
                     recipePlans.add(recipePlanToAdd);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipePlans;

    }

    public RecipePlan create(RecipePlan recipePlan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_RECIPE_PLAN_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setInt(1, recipePlan.getId());
            insertStm.setInt(2, recipePlan.getRecipeId());
            insertStm.setString(3, recipePlan.getMealName());
            insertStm.setInt(4, recipePlan.getDisplayOrder());
            insertStm.setInt(5, recipePlan.getDayNameId());
            insertStm.setInt(6, recipePlan.getPlanId());

            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    recipePlan.setId(generatedKeys.getInt(1));
                    return recipePlan;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(Integer recipeId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_RECIPE_PLAN_QUERY)) {
            statement.setInt(1, recipeId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void update(RecipePlan recipePlan) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_RECIPE_PLAN_QUERY)) {
            statement.setInt(1, recipePlan.getId());
            statement.setInt(2, recipePlan.getRecipeId());
            statement.setString(3, recipePlan.getMealName());
            statement.setInt(4, recipePlan.getDisplayOrder());
            statement.setInt(5, recipePlan.getDayNameId());
            statement.setInt(6, recipePlan.getPlanId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}