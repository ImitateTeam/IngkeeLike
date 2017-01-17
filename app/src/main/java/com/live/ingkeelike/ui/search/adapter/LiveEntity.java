package com.live.ingkeelike.ui.search.adapter;

public class LiveEntity {
    private static final long serialVersionUID = 1L;
    public String buz_url;
    public String city;
    public String create_time;
    public UserEntity creator;
    public String distance;
    public String from;
    public int group;
    public String id = "";
    public String image;
    public String logFrom;
    public int multi;
    public String name;
    public int nopic_line_color = 2131624224;
    public int online_users;
    public int optimal = 0;
    public int pic;
    public int position;
    public int pub;
    public int pub_stat = 1;
    public String publish_addr;
    public String rec;
    public int record_seconds;
    public String record_url;
    public int room_id;
    public int rotate;
    public String share_addr;
    public int slot;
    public int status;
    public String stream_addr;
    public int tag_id;
    public String token;
    public int top;

    public boolean equals(Object paramObject) {
        return this.id.equals(((LiveEntity) paramObject).id);
    }
}