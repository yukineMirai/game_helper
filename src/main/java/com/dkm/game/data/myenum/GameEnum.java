package com.dkm.game.data.myenum;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameEnum {

   public static enum Status{
       VALID("valid","有效"),
       INVALID("invalid","无效");
       private String value;
       private String description;

       private Status(String value,String description){

           this.value  = value;
           this.description = description;
       }

       public static String getName(int index) {
           for (Color c : Color.values()) {
               if (c.getIndex() == index) {
                   return c.name;
               }
           }
           return null;
       }
       // get set 方法
       public String getValue() {
           return value;
       }
       public void setName(String value) {
           this.value = value;
       }
       public String getDescription() {
           return description;
       }
       public void setDescription(String description) {
           this.description = description;
       }
   }

    public enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;
        // 构造方法
        private Color(String name, int index) {
            this.name = name;
            this.index = index;
        }
        // 普通方法
        public static String getName(int index) {
            for (Color c : Color.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
    }

}
