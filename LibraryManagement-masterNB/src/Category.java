public class Category {
    public String name;
    public String slug;

    public Category(String name, String slug) {
        // Constructor for creating categories
        this.name = name;
        this.slug = slug;
    }

    public void getCategory(){
        // Method for getting category
        System.out.println("Category name: "+ name + "Category slug: "+ slug);
    }

    @Override
    public String toString() {
        // Method for printing category
        return this.name;
    }
}

