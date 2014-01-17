package org.wordpress.android.models;

import android.text.TextUtils;

import org.json.JSONObject;
import org.wordpress.android.util.JSONUtil;
import org.wordpress.android.util.StringUtils;

/**
 * Created by nbradbury on 16-Jan-2014
 */
public class ReaderBlog {
    public long blogId;
    public boolean isPrivate;
    public boolean isJetpack;
    public boolean isFollowing;
    public int numSubscribers;
    private String name;
    private String description;
    private String url;

    /*{
    "ID": 3584907,
    "name": "WordPress.com News",
    "description": "The latest news on WordPress.com and the WordPress community.",
    "URL": "http:\/\/en.blog.wordpress.com",
    "jetpack": false,
    "subscribers_count": 9222924,
    "is_private": false,
    "meta": {
        "links": {
            "self": "https:\/\/public-api.wordpress.com\/rest\/v1\/sites\/3584907",
            "help": "https:\/\/public-api.wordpress.com\/rest\/v1\/sites\/3584907\/help",
            "posts": "https:\/\/public-api.wordpress.com\/rest\/v1\/sites\/3584907\/posts\/",
            "comments": "https:\/\/public-api.wordpress.com\/rest\/v1\/sites\/3584907\/comments\/"
        }
    }
    }*/

    public static ReaderBlog fromJson(JSONObject json) {
        ReaderBlog blog = new ReaderBlog();
        if (json == null)
            return blog;

        blog.blogId = json.optLong("ID");
        blog.name = JSONUtil.getStringDecoded(json, "name");
        blog.description = JSONUtil.getStringDecoded(json, "description");
        blog.url = JSONUtil.getString(json, "URL");
        blog.isJetpack = JSONUtil.getBool(json, "jetpack");
        blog.isPrivate = JSONUtil.getBool(json, "is_private");
        blog.isFollowing = JSONUtil.getBool(json, "is_following");
        blog.numSubscribers = json.optInt("subscribers_count");

        return blog;
    }

    public String getName() {
        return StringUtils.notNullStr(name);
    }
    public void setName(String blogName) {
        this.name = StringUtils.notNullStr(blogName);
    }

    public String getUrl() {
        return StringUtils.notNullStr(url);
    }
    public void setUrl(String url) {
        this.url = StringUtils.notNullStr(url);
    }

    public String getDescription() {
        return StringUtils.notNullStr(description);
    }
    public void setDescription(String description) {
        this.description = StringUtils.notNullStr(description);
    }

    public boolean hasDescription() {
        return !TextUtils.isEmpty(description);
    }
}
