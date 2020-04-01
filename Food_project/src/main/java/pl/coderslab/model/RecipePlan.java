package pl.coderslab.model;

public class RecipePlan {
    private int id;
    private int recipeId;
    private int dayNameId;
    private int planId;
    private int displayOrder;
    private String mealName;

    public RecipePlan() {

    }



    @Override
    public String toString() {
        return "RecipePlan{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", dayNameId=" + dayNameId +
                ", planId=" + planId +
                ", displayOrder=" + displayOrder +
                ", mealName='" + mealName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setDayNameId(int dayNameId) {
        this.dayNameId = dayNameId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public int getId() {
        return id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public int getDayNameId() {
        return dayNameId;
    }

    public int getPlanId() {
        return planId;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public String getMealName() {
        return mealName;
    }

    public RecipePlan(int recipeId, int dayNameId, int planId, int displayOrder, String mealName) {
        this.recipeId = recipeId;
        this.dayNameId = dayNameId;
        this.planId = planId;
        this.displayOrder = displayOrder;
        this.mealName = mealName;
    }

}