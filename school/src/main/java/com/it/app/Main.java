package com.it.app;

import com.it.dao.*;
import com.it.dao.impl.*;
import com.it.model.*;
import com.it.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private static final ScheduleMakerDAO scheduleMakerDAO = ScheduleMakerDAOImpl.getInstance();
    private static final RoleDAO roleDAO = RoleDAOImpl.getInstance();
    private static final LevelDAO levelDAO = LevelDAOImpl.getInstance();
    private static final LanguageDAO languageDAO = LanguageDAOImpl.getInstance();
    private static final TutorDAO tutorDAO = TutorDAOImpl.getInstance();
    private static final CourseDAO courseDAO = CourseDAOImpl.getInstance();
    private static final EventDAO eventDAO = EventDAOImpl.getInstance();
    private static final StudentCourseDAO studentCourseDAO = StudentCourseDAOImpl.getInstance();
    private static final TypeOfCourseDAO typeOfCourseDAO = TypeOfCourseDAOImpl.getInstance();

    /**
     * main method
     *
     * @param args - args
     */
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            performLanguageOperation();
            performLevelOperation();
            performRoleOperation();
            performStudentOperation();
            performScheduleMakerOperation();
            performTypeOfCourseOperation();
            performTutorsOperation();
            performEventsOperation();
            performCoursesOperation();
            performStudentCoursesOperation();
        }

    }

    private static void performLanguageOperation() {
        Language language = languageDAO.getOne(1L);
        if (language == null) {
            language = new Language();
            language.setName("English");
            languageDAO.save(language);
        }

        language = languageDAO.getOne(2L);
        if (language == null) {
            language = new Language();
            language.setName("Russian");
            languageDAO.save(language);
        }

        language = languageDAO.getOne(3L);
        if (language == null) {
            language = new Language();
            language.setName("French");
            languageDAO.save(language);
        }
        language = languageDAO.getOne(2L);
        language.setName("German");
        languageDAO.update(language);
        if (language != null) {
            languageDAO.delete(2L);
        }

    }

    private static void performLevelOperation() {
        Level level = levelDAO.getOne(1L);
        if (level == null) {
            level = new Level();
            level.setName("Elementary");
            levelDAO.save(level);
            level = new Level();
            level.setName("Pre-Intermediate");
            levelDAO.save(level);
            level = new Level();
            level.setName("Intermediate");
            levelDAO.save(level);
        }

    }

    private static void performRoleOperation() {
        Role role = roleDAO.getOne(1L);
        if (role == null) {
            role = new Role();
            role.setName("student");
            roleDAO.save(role);
            role = new Role();
            role.setName("maker");
            roleDAO.save(role);
        }
    }

    private static void performStudentOperation() {
        Student student = studentDAO.getOne(1L);
        if (student == null) {
            student = new Student();
            student.setName("Anastasia");
            student.setPhoneNumber("+375333333");
            student.setRole(roleDAO.getOne(1l));
            student.setSurname("Rutkouskaya");
            student.setUsername("nastya_aaa");
            student.setPassword("aaa12345");
            student.setE_mail("mmm@mail.ru");
            studentDAO.save(student);
            System.out.println(studentDAO.findByPhoneNumber("+375333333").getUsername());
        }
    }

    private static void performScheduleMakerOperation() {
        ScheduleMaker maker = scheduleMakerDAO.getOne(1L);
        if (maker == null) {
            maker = new ScheduleMaker();
            maker.setName("Olga");
            maker.setLanguage(languageDAO.getOne(1L));
            maker.setRole(roleDAO.getOne(2l));
            maker.setSurname("Ivanova");
            maker.setUsername("olly");
            maker.setPassword("11112345");
            maker.setE_mail("oll@mail.ru");
            scheduleMakerDAO.save(maker);
            System.out.println(scheduleMakerDAO.findListByLanguage("English", 0, 5).get(0).getUsername());
        }
    }

    private static void performTypeOfCourseOperation() {
        TypeOfCourse typeOfCourse = typeOfCourseDAO.getOne(1L);
        if (typeOfCourse == null) {
            typeOfCourse = new TypeOfCourse();
            typeOfCourse.setName("Express");
            typeOfCourse.setCost(new BigDecimal(150));
            typeOfCourse.setTimeType("Evening");
            typeOfCourseDAO.save(typeOfCourse);
            typeOfCourse = new TypeOfCourse();
            typeOfCourse.setName("Weekends");
            typeOfCourse.setCost(new BigDecimal(330));
            typeOfCourse.setTimeType("Morning");
            typeOfCourseDAO.save(typeOfCourse);
            typeOfCourse = new TypeOfCourse();
            typeOfCourse.setName("Standart");
            typeOfCourse.setCost(new BigDecimal(440));
            typeOfCourse.setTimeType("Evening");
            typeOfCourseDAO.save(typeOfCourse);

        }
    }

    private static void performTutorsOperation() {
        Tutor tutor = tutorDAO.getOne(1L);
        if (tutor == null) {
            tutor = new Tutor();
            tutor.setName("Elena");
            tutor.setSurname("Petrova");
            tutor.setLanguage(languageDAO.getOne(3L));
            Set<Level> levels = new HashSet<>();
            levels.add(levelDAO.getOne(1L));
            levels.add(levelDAO.getOne(3L));
            tutor.setLevels(levels);
            tutorDAO.save(tutor);
            List<Tutor> tutors = tutorDAO.findTutorsByLanguage("French", 0, 10);
            for (Tutor t : tutors
                    ) {
                System.out.println(t.getName() + " " + t.getSurname());

            }
        }
    }

    private static void performEventsOperation() {
        Event event = eventDAO.getOne(1L);
        if (event == null) {
            event = new Event();
            event.setName("Book evening");
            event.setPlaces(15);
            event.setCost(new BigDecimal(7));
            event.setTutor(tutorDAO.getOne(1L));
            eventDAO.save(event);
            Set<Event> events = new HashSet<>();
            event.setPlaces(eventDAO.getOne(1L).getPlaces() - 1);
            events.add(event);
            eventDAO.update(event);
            Student student = studentDAO.getOne(1L);
            student.setEvents(events);
            studentDAO.update(student);
            List<Event> sortEvents = eventDAO.sortEventsByCost(0, 10);
        }
    }

    private static void performCoursesOperation() {
        Course course = courseDAO.getOne(1L);
        if (course == null) {
            course = new Course();
            course.setLanguage(languageDAO.getOne(3L));
            short places = 15;
            course.setPlaces(places);
            course.setLevel(levelDAO.getOne(3L));
            course.setTutor(tutorDAO.getOne(1L));
            course.setStartDate(LocalDate.of(2019, 4, 12));
            course.setTypeOfCourse(typeOfCourseDAO.getOne(3L));
            courseDAO.save(course);
            List<Course> courses = courseDAO.sortCoursesByFreePlaces(0, 10);
            courses = courseDAO.findCoursesByLanguage("French", 0, 10);
        }
    }

    private static void performStudentCoursesOperation() {
        if (studentDAO.enrolIInCourse(courseDAO.getOne(1L), studentDAO.getOne(1L), studentCourseDAO))
            System.out.println("Your application is accepted");
        else System.out.println("No free places");

        List<StudentCourse> studentCourses = studentCourseDAO.findUnacceptedApplications(0, 11);
        for (StudentCourse studentCourse : studentCourses
                ) {
            System.out.println(studentCourse.getStatus());
        }
    }
}
