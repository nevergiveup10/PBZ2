package sample;

public class Data {
    private  String time;
    private  String day;
    private  int volume;
    private int id;
    private String name;
    private String address;
    private String park;
    private int zone;
    private String type;
    private String plantDate;
    private int age;
    private int parkId;
    private String fullName;
    private String number;
    private String schedule;
    private String specialty;
    private String educationLevel;
    private String studyPlace;
    private String status;

    public Data(int id, String name, String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public Data(int id, String park, Integer zone){
        this.id=id;
        this.park=park;
        this.zone=zone;
    }

    public Data(int id, String type, String plantDate, int age, int parkId, int zone){
        this.id=id;
        this.type=type;
        this.plantDate=plantDate;
        this.age=age;
        this.parkId=parkId;
        this.zone=zone;
    }

    public Data(int id, String fullName, String number, String address, String schedule){
        this.id=id;
        this.fullName=fullName;
        this.number=number;
        this.address=address;
        this.schedule=schedule;
    }

    public Data(int id, String fullName, String number, String address, String specialty, String studyPlace, String educationLevel, String schedule){
        this.id=id;
        this.fullName=fullName;
        this.number=number;
        this.specialty=specialty;
        this.studyPlace=studyPlace;
        this.educationLevel=educationLevel;
        this.address=address;
        this.schedule=schedule;
    }

    public Data(String status, String fullName, String address, String number) {
        this.status=status;
        this.fullName = fullName;
        this.address=address;
        this.number=number;
    }

    public Data(int id, String type, int age, String day, String time, int volume) {
        this.id=id;
        this.type=type;
        this.age=age;
        this.day=day;
        this.time=time;
        this.volume=volume;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public int getZone() { return zone; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(String plantDate) {
        this.plantDate = plantDate;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getParkId() { return parkId; }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() { return age; }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public void setStudyPlace(String studyPlace) {
        this.studyPlace = studyPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}