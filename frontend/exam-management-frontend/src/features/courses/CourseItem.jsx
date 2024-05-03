import { MdEditDocument,MdDelete  } from "react-icons/md";
import { useDeleteCourse } from "./useDeleteCourse";
import { useState } from "react";
import CreateCoursesForm from "./CreateCoursesForm";


function CourseItem({course}){

    const[editForm,setEditForm] = useState(false);

    const {courseId,courseName,courseDescription,courseCode} = course;


   const {deleteCourses,isDeleting} = useDeleteCourse();


   const onEditCourse=()=>{
    setEditForm((show)=> !show);
   }

    return (
        <>
       <div className="grid grid-cols-[0.5fr_0.5fr_1fr_auto_0.5fr] gap-4 items-center justify-items-center p-3 border-b-2">
            <h2>{courseName}</h2>
            <h2 className="uppercase">{courseCode}</h2>
            <p>{courseDescription}</p>
            <button className="hover:cursor-pointer" onClick={onEditCourse}>
            <MdEditDocument size={25} />
            </button>
            
            <button disabled={isDeleting} onClick={()=>deleteCourses(courseId)}><MdDelete size={25} /></button>
       </div>
       

       {editForm && 
       <div className="border-2" >

       <CreateCoursesForm currentCourse={course} setEditForm={setEditForm}  />
       </div>
}
       </>
    )

}

export default CourseItem;