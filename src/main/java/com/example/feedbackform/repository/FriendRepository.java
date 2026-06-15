package com.example.feedbackform.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.feedbackform.model.Friend;

import java.util.List;

@Repository
public class FriendRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveFriend(Friend friend) {
       
    	String hobbiesText = "";

    	if (friend.getHobbies() != null) {
    	    hobbiesText = String.join(", ", friend.getHobbies());
    	}

    	if(friend.getOtherHobby() != null &&
    	   !friend.getOtherHobby().trim().isEmpty()) {

    	    if(!hobbiesText.isEmpty()) {
    	        hobbiesText += ", ";
    	    }

    	    hobbiesText += friend.getOtherHobby();
    	}
        String sql = """
            INSERT INTO friends_info
            (
                full_name,
                dob,
                age,
                mobile,
                email,
                favorite_food,
                favorite_movie,
                favorite_color,
                favorite_place,
                hobbies,
                strength,
                motivation,
                happiness,
                about_me
            )
            VALUES
            (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
       
        jdbcTemplate.update(
                sql,

                friend.getFullName(),
                friend.getDob(),
                friend.getAge(),
                friend.getMobile(),
                friend.getEmail(),

                friend.getFavoriteFood(),
                friend.getFavoriteMovie(),
                friend.getFavoriteColor(),
                friend.getFavoritePlace(),

                hobbiesText,

                friend.getStrength(),
                friend.getMotivation(),
                friend.getHappiness(),

                friend.getAboutMe()
        );
    }
    
    public List<Friend> getAllFriends() {

        String sql = "SELECT * FROM friends_info";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
        new Friend(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("dob"),
                rs.getInt("age"),
                rs.getString("mobile"),
                rs.getString("email"),
                rs.getString("favorite_food"),
                rs.getString("favorite_movie"),
                rs.getString("favorite_color"),
                rs.getString("favorite_place"),
                rs.getString("hobbies"),
                rs.getString("strength"),
                rs.getString("motivation"),
                rs.getString("happiness"),
                rs.getString("about_me")
        )
        );
    }
    
    public void deleteFriend(int id) {

        String sql =
                "DELETE FROM friends_info WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
    public List<Friend> searchFriends(String name) {

        String sql =
            "SELECT * FROM friends_info WHERE full_name LIKE ?";

        return jdbcTemplate.query(
                sql,
                ps -> ps.setString(1, "%" + name + "%"),
                (rs, rowNum) -> new Friend(
                    rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("dob"),
                    rs.getInt("age"),
                    rs.getString("mobile"),
                    rs.getString("email"),
                    rs.getString("favorite_food"),
                    rs.getString("favorite_movie"),
                    rs.getString("favorite_color"),
                    rs.getString("favorite_place"),
                    rs.getString("hobbies"),
                    rs.getString("strength"),
                    rs.getString("motivation"),
                    rs.getString("happiness"),
                    rs.getString("about_me")
                )
        );
    }
    public void updateFriend(Friend friend) {

        String hobbiesText = "";

        if (friend.getHobbies() != null) {
            hobbiesText = String.join(", ", friend.getHobbies());
        }

        if (friend.getOtherHobby() != null &&
            !friend.getOtherHobby().trim().isEmpty()) {

            if (!hobbiesText.isEmpty()) {
                hobbiesText += ", ";
            }

            hobbiesText += friend.getOtherHobby();
        }

        String sql =
            """
            UPDATE friends_info
            SET
                full_name = ?,
                dob = ?,
                age = ?,
                mobile = ?,
                email = ?,
                favorite_food = ?,
                favorite_movie = ?,
                favorite_color = ?,
                favorite_place = ?,
                hobbies = ?,
                strength = ?,
                motivation = ?,
                happiness = ?,
                about_me = ?
            WHERE id = ?
            """;

        jdbcTemplate.update(
                sql,

                friend.getFullName(),
                friend.getDob(),
                friend.getAge(),
                friend.getMobile(),
                friend.getEmail(),

                friend.getFavoriteFood(),
                friend.getFavoriteMovie(),
                friend.getFavoriteColor(),
                friend.getFavoritePlace(),

                hobbiesText,

                friend.getStrength(),
                friend.getMotivation(),
                friend.getHappiness(),
                friend.getAboutMe(),

                friend.getId()
        );
    }
    public Friend getFriendById(int id) {

        String sql =
                "SELECT * FROM friends_info WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    Friend friend = new Friend();

                    friend.setId(rs.getInt("id"));
                    friend.setFullName(rs.getString("full_name"));
                    friend.setDob(rs.getString("dob"));
                    friend.setAge(rs.getInt("age"));
                    friend.setMobile(rs.getString("mobile"));
                    friend.setEmail(rs.getString("email"));

                    friend.setFavoriteFood(rs.getString("favorite_food"));
                    friend.setFavoriteMovie(rs.getString("favorite_movie"));
                    friend.setFavoriteColor(rs.getString("favorite_color"));
                    friend.setFavoritePlace(rs.getString("favorite_place"));

                    // Important
                    friend.setHobbiesText(rs.getString("hobbies"));
                    
                    friend.setStrength(rs.getString("strength"));
                    friend.setMotivation(rs.getString("motivation"));
                    friend.setHappiness(rs.getString("happiness"));
                    friend.setAboutMe(rs.getString("about_me"));

                    return friend;
                },
                id
        );
    }
}