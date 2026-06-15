package com.example.feedbackform.model;

public class Friend {
    private Integer id;
    private String fullName;
    private String dob;
    private Integer age;
	private String mobile;
    private String email;

    private String favoriteFood;
    private String favoriteMovie;
    private String favoriteColor;
    private String favoritePlace;

    private String[] hobbies;
    private String hobbiesText;
    private String otherHobby;
    
    private String strength;
    private String motivation;
    private String happiness;

    private String aboutMe;

 // Default Constructor
    public Friend() {

    }
    
 // Parameterized Constructor
    public Friend(
    		Integer id,
            String fullName,
            String dob,
            Integer age,
            String mobile,
            String email,
            String favoriteFood,
            String favoriteMovie,
            String favoriteColor,
            String favoritePlace,
            String hobbiesText,
            String strength,
            String motivation,
            String happiness,
            String aboutMe) {
    	this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.age = age;
        this.mobile = mobile;
        this.email = email;

        this.favoriteFood = favoriteFood;
        this.favoriteMovie = favoriteMovie;
        this.favoriteColor = favoriteColor;
        this.favoritePlace = favoritePlace;

        this.hobbiesText = hobbiesText;

        this.strength = strength;
        this.motivation = motivation;
        this.happiness = happiness;

        this.aboutMe = aboutMe;
    }
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getFavoritePlace() {
        return favoritePlace;
    }

    public void setFavoritePlace(String favoritePlace) {
        this.favoritePlace = favoritePlace;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
    
    public String getHobbiesText() {
        return hobbiesText;
    }

    public void setHobbiesText(String hobbiesText) {
        this.hobbiesText = hobbiesText;
    }
    public String getOtherHobby() {
        return otherHobby;
    }

    public void setOtherHobby(String otherHobby) {
        this.otherHobby = otherHobby;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getHappiness() {
        return happiness;
    }

    public void setHappiness(String happiness) {
        this.happiness = happiness;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}