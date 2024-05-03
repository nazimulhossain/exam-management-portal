import { useCourses } from "./useCourses";

import CourseItem from "./CourseItem";


function CoursesTable(){

    const {courses} = useCourses();


    return(
    <>
        <div className="border-2 border-slate-200 bg-white" role="table">
        <header className="grid grid-cols-[0.5fr_0.5fr_1fr_auto_0.5fr] justify-items-center gap-8  bg-slate-200 p-3 uppercase " role="header">
            <div>
                Name
            </div>
            <div>
                Course code
            </div>
            <div>
            Description
            </div>
            <div>
                Edit
            </div>
            <div>
                Delete
            </div>
            </header>
             {
                 courses?.data.map((course)=> <CourseItem course={course} key={course.courseId} />)
                }
                
                  
                </div>
                
        
            
        </>

    )

}

export default CoursesTable;