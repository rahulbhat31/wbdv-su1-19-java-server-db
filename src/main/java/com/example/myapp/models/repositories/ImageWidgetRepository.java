//package com.example.myapp.models.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import com.example.myapp.models.HeadingWidget;
//import com.example.myapp.models.ImageWidget;
//import com.example.myapp.models.Widget;
//
//public interface ImageWidgetRepository extends CrudRepository<ImageWidget, Integer>{
////	@Query("Select W from Course C inner join C.includedmodules M inner join M.includedLessons L inner join L.includedTopics T inner join T.includedWidgets W where W.id =:widgetId AND W.wtype='IMAGE'")
////	Widget findWidgetInTopic(@Param("widgetId") int widgetId);
////	
////	@Query("Select W from Course C inner join C.includedmodules M inner join M.includedLessons L inner join L.includedTopics T inner join T.includedWidgets W where T.id =:topicId AND W.wtype='IMAGE'")
////	List<Widget> findAllWidgets(@Param("topicId") int topicId);
//}
