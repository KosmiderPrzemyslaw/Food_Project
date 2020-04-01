package pl.coderslab.dao;

import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Book;
import pl.coderslab.model.DayName;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DayNameDao {
    // ZAPYTANIA SQL
    private static final String CREATE_DAY_NAME_QUERY = "INSERT INTO day_name(name, display_order) VALUES (?,?);";
    private static final String DELETE_DAY_NAME_QUERY = "DELETE FROM day_name WHERE id = ?;";
    private static final String FIND_ALL_DAY_NAMES_QUERY = "SELECT * FROM day_name ;";
    private static final String READ_DAY_NAME_QUERY = "SELECT * FROM day_name WHERE id = ?;";
    private static final String UPDATE_DAY_NAME_QUERY = "UPDATE day_name SET name = ? , display_order = ? WHERE id = ?;";

    /**
     * Get dayName by id
     *
     * @param dayNameId
     * @return
     */
    public DayName read(Integer dayNameId) {
        DayName dayName = new DayName();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_DAY_NAME_QUERY)
        ) {
            statement.setInt(1, dayNameId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    dayName.setId(resultSet.getInt("id"));
                    dayName.setName(resultSet.getString("name"));
                    dayName.setDisplayOrder(resultSet.getInt("display_order"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayName;
    }

    /**
     * Return all dayNames
     *
     * @return
     */
    public List<DayName> findAll() {
        List<DayName> dayNames = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DAY_NAMES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                DayName dayNameToAdd = new DayName();
                dayNameToAdd.setId(resultSet.getInt("id"));
                dayNameToAdd.setName(resultSet.getString("name"));
                dayNameToAdd.setDisplayOrder(resultSet.getInt("display_order"));
                dayNames.add(dayNameToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayNames;
    }

    /**
     * Create dayName
     *
     * @param dayName
     * @return
     */
    public DayName create(DayName dayName) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_DAY_NAME_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, dayName.getName());
            insertStm.setInt(2, dayName.getDisplayOrder());
            int result = insertStm.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    dayName.setId(generatedKeys.getInt(1));
                    return dayName;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Remove dayName by id
     *
     * @param dayNameId
     */
    public void delete(Integer dayNameId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_DAY_NAME_QUERY)) {
            statement.setInt(1, dayNameId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update dayName
     *
     * @param dayName
     */
    public void update(DayName dayName) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DAY_NAME_QUERY)) {
            statement.setInt(3, dayName.getId());
            statement.setString(1, dayName.getName());
            statement.setInt(2, dayName.getDisplayOrder());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
