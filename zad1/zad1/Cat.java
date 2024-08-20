class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}