package com.bidostar.dblibrary.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bidostar.dblibrary.bean.UserBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER_BEAN".
*/
public class UserBeanDao extends AbstractDao<UserBean, Long> {

    public static final String TABLENAME = "USER_BEAN";

    /**
     * Properties of entity UserBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, int.class, "age", false, "AGE");
        public final static Property Address = new Property(3, String.class, "address", false, "ADDRESS");
        public final static Property Sex = new Property(4, int.class, "sex", false, "SEX");
        public final static Property HeadImgUrl = new Property(5, String.class, "headImgUrl", false, "HEAD_IMG_URL");
        public final static Property Signature = new Property(6, String.class, "signature", false, "SIGNATURE");
        public final static Property MaxAge = new Property(7, int.class, "maxAge", false, "MAX_AGE");
        public final static Property Fuck = new Property(8, String.class, "fuck", false, "FUCK");
        public final static Property Height = new Property(9, int.class, "height", false, "HEIGHT");
        public final static Property WxHeadImgUrl = new Property(10, String.class, "wxHeadImgUrl", false, "WX_HEAD_IMG_URL");
        public final static Property Width = new Property(11, int.class, "width", false, "WIDTH");
        public final static Property ChineseScore = new Property(12, int.class, "chineseScore", false, "CHINESE_SCORE");
        public final static Property ChineseName = new Property(13, String.class, "chineseName", false, "CHINESE_NAME");
    }


    public UserBeanDao(DaoConfig config) {
        super(config);
    }
    
    public UserBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"AGE\" INTEGER NOT NULL ," + // 2: age
                "\"ADDRESS\" TEXT," + // 3: address
                "\"SEX\" INTEGER NOT NULL ," + // 4: sex
                "\"HEAD_IMG_URL\" TEXT," + // 5: headImgUrl
                "\"SIGNATURE\" TEXT," + // 6: signature
                "\"MAX_AGE\" INTEGER NOT NULL ," + // 7: maxAge
                "\"FUCK\" TEXT," + // 8: fuck
                "\"HEIGHT\" INTEGER NOT NULL ," + // 9: height
                "\"WX_HEAD_IMG_URL\" TEXT," + // 10: wxHeadImgUrl
                "\"WIDTH\" INTEGER NOT NULL ," + // 11: width
                "\"CHINESE_SCORE\" INTEGER NOT NULL ," + // 12: chineseScore
                "\"CHINESE_NAME\" TEXT);"); // 13: chineseName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
        stmt.bindLong(5, entity.getSex());
 
        String headImgUrl = entity.getHeadImgUrl();
        if (headImgUrl != null) {
            stmt.bindString(6, headImgUrl);
        }
 
        String signature = entity.getSignature();
        if (signature != null) {
            stmt.bindString(7, signature);
        }
        stmt.bindLong(8, entity.getMaxAge());
 
        String fuck = entity.getFuck();
        if (fuck != null) {
            stmt.bindString(9, fuck);
        }
        stmt.bindLong(10, entity.getHeight());
 
        String wxHeadImgUrl = entity.getWxHeadImgUrl();
        if (wxHeadImgUrl != null) {
            stmt.bindString(11, wxHeadImgUrl);
        }
        stmt.bindLong(12, entity.getWidth());
        stmt.bindLong(13, entity.getChineseScore());
 
        String chineseName = entity.getChineseName();
        if (chineseName != null) {
            stmt.bindString(14, chineseName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UserBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getAge());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(4, address);
        }
        stmt.bindLong(5, entity.getSex());
 
        String headImgUrl = entity.getHeadImgUrl();
        if (headImgUrl != null) {
            stmt.bindString(6, headImgUrl);
        }
 
        String signature = entity.getSignature();
        if (signature != null) {
            stmt.bindString(7, signature);
        }
        stmt.bindLong(8, entity.getMaxAge());
 
        String fuck = entity.getFuck();
        if (fuck != null) {
            stmt.bindString(9, fuck);
        }
        stmt.bindLong(10, entity.getHeight());
 
        String wxHeadImgUrl = entity.getWxHeadImgUrl();
        if (wxHeadImgUrl != null) {
            stmt.bindString(11, wxHeadImgUrl);
        }
        stmt.bindLong(12, entity.getWidth());
        stmt.bindLong(13, entity.getChineseScore());
 
        String chineseName = entity.getChineseName();
        if (chineseName != null) {
            stmt.bindString(14, chineseName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UserBean readEntity(Cursor cursor, int offset) {
        UserBean entity = new UserBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // age
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // address
            cursor.getInt(offset + 4), // sex
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // headImgUrl
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // signature
            cursor.getInt(offset + 7), // maxAge
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // fuck
            cursor.getInt(offset + 9), // height
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // wxHeadImgUrl
            cursor.getInt(offset + 11), // width
            cursor.getInt(offset + 12), // chineseScore
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13) // chineseName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UserBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.getInt(offset + 2));
        entity.setAddress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSex(cursor.getInt(offset + 4));
        entity.setHeadImgUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setSignature(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMaxAge(cursor.getInt(offset + 7));
        entity.setFuck(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setHeight(cursor.getInt(offset + 9));
        entity.setWxHeadImgUrl(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWidth(cursor.getInt(offset + 11));
        entity.setChineseScore(cursor.getInt(offset + 12));
        entity.setChineseName(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UserBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UserBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UserBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
