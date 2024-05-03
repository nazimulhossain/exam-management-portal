
import { useParams } from "react-router-dom";
import Button from "../../ui/Button";
import { useState } from "react";
import CreateBatchesForm from "../batches/CreateBatchesForm";
import SelectSemester from "./SelectSemester";
import { useSemesterByCourse } from "../semesters/useSemesterByCourse";

function CourseExam(){
    const [showCreateForm,setShowCreateForm] = useState(false);
    const {courseName} = useParams();


    const {semestersbycourse} = useSemesterByCourse(courseName);
    

    return (
        <>
        <h2 className="text-3xl mb-4">All Semesters</h2>
       
{!semestersbycourse?.length ? <div className="mb-8"><Button onClick={()=> setShowCreateForm((show)=> !show)}>Add a Semester</Button></div> : 

<div>
<p className="text-lg mb-4">Choose a semester</p>
<ul className="flex flex-col gap-3 border-2 bg-white p-4 ">
  {
      semestersbycourse?.map((semester)=> <SelectSemester semester={semester} key={semester.id} courseName={courseName} /> )
  }
</ul>
</div>}
        
        {
            showCreateForm && <CreateBatchesForm courseName={courseName} setShowCreateForm={setShowCreateForm} />
        }
        </>
    )

}

export default CourseExam;