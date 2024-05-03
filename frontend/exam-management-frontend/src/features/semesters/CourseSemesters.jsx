import { useState } from "react";
import {  useParams } from "react-router-dom";

import Button from "../../ui/Button";
import { useSemesterByCourse} from "./useSemesterByCourse";
import SemestersTable from "./SemestersTable";
import CreateSemestersForm from "./CreateSemestersForm";



function CourseSemesters(){
   
    const [showCreateForm,setShowCreateForm] = useState(false);


 
    
    const {courseName} = useParams();

    const {semestersbycourse} = useSemesterByCourse(courseName);

 


    const showForm = ()=>{
        
        setShowCreateForm((show)=> !show);
        
    }

 




    return (
        <>
        <h2 className="text-3xl mb-4">All Semester</h2>
       
{semestersbycourse?.length===0 ? <div className="mb-8">
    <p className="mb-4">No semesters found on {courseName} course</p>
    
    </div> :  <SemestersTable semesters={semestersbycourse}  />}

    <Button onClick={showForm}>Add a Semester</Button>
        {
            showCreateForm && <CreateSemestersForm courseName={courseName} setShowCreateForm={setShowCreateForm} />
        }
        </>
    )

}

export default CourseSemesters;