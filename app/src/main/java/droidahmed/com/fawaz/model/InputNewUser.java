package droidahmed.com.fawaz.model;

/**
 * Created by ahmed on 4/4/2016.
 */
public class InputNewUser {
        private int  FullName;
        private String UserName;
        private int Password;
        private String Email;
        private int Mobile;
        private String Picture;
        private String Zone;
        private String Widget;
        private String Street;
        private String Gada;
        private String House;

        public InputNewUser() {
        }

        public InputNewUser(int fullName, String userName, int password, String email, int mobile,
                            String picture, String zone, String widget, String street,
                            String gada, String house) {
                FullName = fullName;
                UserName = userName;
                Password = password;
                Email = email;
                Mobile = mobile;
                Picture = picture;
                Zone = zone;
                Widget = widget;
                Street = street;
                Gada = gada;
                House = house;
        }

        public int getFullName() {
                return FullName;
        }

        public void setFullName(int fullName) {
                FullName = fullName;
        }

        public String getUserName() {
                return UserName;
        }

        public void setUserName(String userName) {
                UserName = userName;
        }

        public int getPassword() {
                return Password;
        }

        public void setPassword(int password) {
                Password = password;
        }

        public String getEmail() {
                return Email;
        }

        public void setEmail(String email) {
                Email = email;
        }

        public int getMobile() {
                return Mobile;
        }

        public void setMobile(int mobile) {
                Mobile = mobile;
        }

        public String getPicture() {
                return Picture;
        }

        public void setPicture(String picture) {
                Picture = picture;
        }

        public String getZone() {
                return Zone;
        }

        public void setZone(String zone) {
                Zone = zone;
        }

        public String getWidget() {
                return Widget;
        }

        public void setWidget(String widget) {
                Widget = widget;
        }

        public String getStreet() {
                return Street;
        }

        public void setStreet(String street) {
                Street = street;
        }

        public String getGada() {
                return Gada;
        }

        public void setGada(String gada) {
                Gada = gada;
        }

        public String getHouse() {
                return House;
        }

        public void setHouse(String house) {
                House = house;
        }
}
