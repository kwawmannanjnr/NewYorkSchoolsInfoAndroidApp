package com.kwawannan.newyorkschools.domain;

/**
 * Created by Kwaw Annan on 3/23/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NYCSchool {

    @SerializedName("academicopportunities1")
    @Expose
    private String academicopportunities1;
    @SerializedName("academicopportunities2")
    @Expose
    private String academicopportunities2;
    @SerializedName("admissionspriority11")
    @Expose
    private String admissionspriority11;
    @SerializedName("admissionspriority21")
    @Expose
    private String admissionspriority21;
    @SerializedName("admissionspriority31")
    @Expose
    private String admissionspriority31;
    @SerializedName("attendance_rate")
    @Expose
    private String attendanceRate;
    @SerializedName("bbl")
    @Expose
    private String bbl;
    @SerializedName("bin")
    @Expose
    private String bin;
    @SerializedName("boro")
    @Expose
    private String boro;
    @SerializedName("borough")
    @Expose
    private String borough;
    @SerializedName("building_code")
    @Expose
    private String buildingCode;
    @SerializedName("bus")
    @Expose
    private String bus;
    @SerializedName("census_tract")
    @Expose
    private String censusTract;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("code1")
    @Expose
    private String code1;
    @SerializedName("community_board")
    @Expose
    private String communityBoard;
    @SerializedName("council_district")
    @Expose
    private String councilDistrict;
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("directions1")
    @Expose
    private String directions1;
    @SerializedName("ell_programs")
    @Expose
    private String ellPrograms;
    @SerializedName("extracurricular_activities")
    @Expose
    private String extracurricularActivities;
    @SerializedName("fax_number")
    @Expose
    private String faxNumber;
    @SerializedName("finalgrades")
    @Expose
    private String finalgrades;
    @SerializedName("grade9geapplicants1")
    @Expose
    private String grade9geapplicants1;
    @SerializedName("grade9geapplicantsperseat1")
    @Expose
    private String grade9geapplicantsperseat1;
    @SerializedName("grade9gefilledflag1")
    @Expose
    private String grade9gefilledflag1;
    @SerializedName("grade9swdapplicants1")
    @Expose
    private String grade9swdapplicants1;
    @SerializedName("grade9swdapplicantsperseat1")
    @Expose
    private String grade9swdapplicantsperseat1;
    @SerializedName("grade9swdfilledflag1")
    @Expose
    private String grade9swdfilledflag1;
    @SerializedName("grades2018")
    @Expose
    private String grades2018;
    @SerializedName("interest1")
    @Expose
    private String interest1;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("method1")
    @Expose
    private String method1;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("nta")
    @Expose
    private String nta;
    @SerializedName("offer_rate1")
    @Expose
    private String offerRate1;
    @SerializedName("overview_paragraph")
    @Expose
    private String overviewParagraph;
    @SerializedName("pct_stu_enough_variety")
    @Expose
    private String pctStuEnoughVariety;
    @SerializedName("pct_stu_safe")
    @Expose
    private String pctStuSafe;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("primary_address_line_1")
    @Expose
    private String primaryAddressLine1;
    @SerializedName("program1")
    @Expose
    private String program1;
    @SerializedName("requirement1_1")
    @Expose
    private String requirement11;
    @SerializedName("requirement2_1")
    @Expose
    private String requirement21;
    @SerializedName("requirement3_1")
    @Expose
    private String requirement31;
    @SerializedName("requirement4_1")
    @Expose
    private String requirement41;
    @SerializedName("requirement5_1")
    @Expose
    private String requirement51;
    @SerializedName("school_10th_seats")
    @Expose
    private String school10thSeats;
    @SerializedName("school_accessibility_description")
    @Expose
    private String schoolAccessibilityDescription;
    @SerializedName("school_email")
    @Expose
    private String schoolEmail;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("school_sports")
    @Expose
    private String schoolSports;
    @SerializedName("seats101")
    @Expose
    private String seats101;
    @SerializedName("seats9ge1")
    @Expose
    private String seats9ge1;
    @SerializedName("seats9swd1")
    @Expose
    private String seats9swd1;
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    @SerializedName("subway")
    @Expose
    private String subway;
    @SerializedName("total_students")
    @Expose
    private String totalStudents;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("academicopportunities3")
    @Expose
    private String academicopportunities3;
    @SerializedName("addtl_info1")
    @Expose
    private String addtlInfo1;
    @SerializedName("eligibility1")
    @Expose
    private String eligibility1;
    @SerializedName("language_classes")
    @Expose
    private String languageClasses;
    @SerializedName("transfer")
    @Expose
    private String transfer;

    public String getAcademicopportunities1() {
        return academicopportunities1;
    }

    public void setAcademicopportunities1(String academicopportunities1) {
        this.academicopportunities1 = academicopportunities1;
    }

    public String getAcademicopportunities2() {
        return academicopportunities2;
    }

    public void setAcademicopportunities2(String academicopportunities2) {
        this.academicopportunities2 = academicopportunities2;
    }

    public String getAdmissionspriority11() {
        return admissionspriority11;
    }

    public void setAdmissionspriority11(String admissionspriority11) {
        this.admissionspriority11 = admissionspriority11;
    }

    public String getAdmissionspriority21() {
        return admissionspriority21;
    }

    public void setAdmissionspriority21(String admissionspriority21) {
        this.admissionspriority21 = admissionspriority21;
    }

    public String getAdmissionspriority31() {
        return admissionspriority31;
    }

    public void setAdmissionspriority31(String admissionspriority31) {
        this.admissionspriority31 = admissionspriority31;
    }

    public String getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(String attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public String getBbl() {
        return bbl;
    }

    public void setBbl(String bbl) {
        this.bbl = bbl;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(String communityBoard) {
        this.communityBoard = communityBoard;
    }

    public String getCouncilDistrict() {
        return councilDistrict;
    }

    public void setCouncilDistrict(String councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getDirections1() {
        return directions1;
    }

    public void setDirections1(String directions1) {
        this.directions1 = directions1;
    }

    public String getEllPrograms() {
        return ellPrograms;
    }

    public void setEllPrograms(String ellPrograms) {
        this.ellPrograms = ellPrograms;
    }

    public String getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(String extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFinalgrades() {
        return finalgrades;
    }

    public void setFinalgrades(String finalgrades) {
        this.finalgrades = finalgrades;
    }

    public String getGrade9geapplicants1() {
        return grade9geapplicants1;
    }

    public void setGrade9geapplicants1(String grade9geapplicants1) {
        this.grade9geapplicants1 = grade9geapplicants1;
    }

    public String getGrade9geapplicantsperseat1() {
        return grade9geapplicantsperseat1;
    }

    public void setGrade9geapplicantsperseat1(String grade9geapplicantsperseat1) {
        this.grade9geapplicantsperseat1 = grade9geapplicantsperseat1;
    }

    public String getGrade9gefilledflag1() {
        return grade9gefilledflag1;
    }

    public void setGrade9gefilledflag1(String grade9gefilledflag1) {
        this.grade9gefilledflag1 = grade9gefilledflag1;
    }

    public String getGrade9swdapplicants1() {
        return grade9swdapplicants1;
    }

    public void setGrade9swdapplicants1(String grade9swdapplicants1) {
        this.grade9swdapplicants1 = grade9swdapplicants1;
    }

    public String getGrade9swdapplicantsperseat1() {
        return grade9swdapplicantsperseat1;
    }

    public void setGrade9swdapplicantsperseat1(String grade9swdapplicantsperseat1) {
        this.grade9swdapplicantsperseat1 = grade9swdapplicantsperseat1;
    }

    public String getGrade9swdfilledflag1() {
        return grade9swdfilledflag1;
    }

    public void setGrade9swdfilledflag1(String grade9swdfilledflag1) {
        this.grade9swdfilledflag1 = grade9swdfilledflag1;
    }

    public String getGrades2018() {
        return grades2018;
    }

    public void setGrades2018(String grades2018) {
        this.grades2018 = grades2018;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMethod1() {
        return method1;
    }

    public void setMethod1(String method1) {
        this.method1 = method1;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public String getOfferRate1() {
        return offerRate1;
    }

    public void setOfferRate1(String offerRate1) {
        this.offerRate1 = offerRate1;
    }

    public String getOverviewParagraph() {
        return overviewParagraph;
    }

    public void setOverviewParagraph(String overviewParagraph) {
        this.overviewParagraph = overviewParagraph;
    }

    public String getPctStuEnoughVariety() {
        return pctStuEnoughVariety;
    }

    public void setPctStuEnoughVariety(String pctStuEnoughVariety) {
        this.pctStuEnoughVariety = pctStuEnoughVariety;
    }

    public String getPctStuSafe() {
        return pctStuSafe;
    }

    public void setPctStuSafe(String pctStuSafe) {
        this.pctStuSafe = pctStuSafe;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public void setPrimaryAddressLine1(String primaryAddressLine1) {
        this.primaryAddressLine1 = primaryAddressLine1;
    }

    public String getProgram1() {
        return program1;
    }

    public void setProgram1(String program1) {
        this.program1 = program1;
    }

    public String getRequirement11() {
        return requirement11;
    }

    public void setRequirement11(String requirement11) {
        this.requirement11 = requirement11;
    }

    public String getRequirement21() {
        return requirement21;
    }

    public void setRequirement21(String requirement21) {
        this.requirement21 = requirement21;
    }

    public String getRequirement31() {
        return requirement31;
    }

    public void setRequirement31(String requirement31) {
        this.requirement31 = requirement31;
    }

    public String getRequirement41() {
        return requirement41;
    }

    public void setRequirement41(String requirement41) {
        this.requirement41 = requirement41;
    }

    public String getRequirement51() {
        return requirement51;
    }

    public void setRequirement51(String requirement51) {
        this.requirement51 = requirement51;
    }

    public String getSchool10thSeats() {
        return school10thSeats;
    }

    public void setSchool10thSeats(String school10thSeats) {
        this.school10thSeats = school10thSeats;
    }

    public String getSchoolAccessibilityDescription() {
        return schoolAccessibilityDescription;
    }

    public void setSchoolAccessibilityDescription(String schoolAccessibilityDescription) {
        this.schoolAccessibilityDescription = schoolAccessibilityDescription;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public void setSchoolSports(String schoolSports) {
        this.schoolSports = schoolSports;
    }

    public String getSeats101() {
        return seats101;
    }

    public void setSeats101(String seats101) {
        this.seats101 = seats101;
    }

    public String getSeats9ge1() {
        return seats9ge1;
    }

    public void setSeats9ge1(String seats9ge1) {
        this.seats9ge1 = seats9ge1;
    }

    public String getSeats9swd1() {
        return seats9swd1;
    }

    public void setSeats9swd1(String seats9swd1) {
        this.seats9swd1 = seats9swd1;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }

    public String getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(String totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAcademicopportunities3() {
        return academicopportunities3;
    }

    public void setAcademicopportunities3(String academicopportunities3) {
        this.academicopportunities3 = academicopportunities3;
    }

    public String getAddtlInfo1() {
        return addtlInfo1;
    }

    public void setAddtlInfo1(String addtlInfo1) {
        this.addtlInfo1 = addtlInfo1;
    }

    public String getEligibility1() {
        return eligibility1;
    }

    public void setEligibility1(String eligibility1) {
        this.eligibility1 = eligibility1;
    }

    public String getLanguageClasses() {
        return languageClasses;
    }

    public void setLanguageClasses(String languageClasses) {
        this.languageClasses = languageClasses;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

}
