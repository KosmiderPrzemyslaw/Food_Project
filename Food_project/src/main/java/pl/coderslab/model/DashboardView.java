package pl.coderslab.model;

public class DashboardView {
    String planName;
    String dayName;
    String mealName;
    String description;
    Integer recipeId;

    public DashboardView(String planName, String dayName, String mealName, String description, Integer recipeId) {
        this.planName = planName;
        this.dayName = dayName;
        this.mealName = mealName;
        this.description = description;
        this.recipeId = recipeId;
    }

    public DashboardView() {
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public String toString() {
        return "DashboardView{" +
                "planName='" + planName + '\'' +
                ", dayName='" + dayName + '\'' +
                ", mealName='" + mealName + '\'' +
                ", description='" + description + '\'' +
                ", recipeId=" + recipeId +
                '}';
    }
}

