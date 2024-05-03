import { useState } from "react";
import CreateCoursesForm from "../features/courses/CreateCoursesForm";
import Button from "../ui/Button";
import CoursesTable from "../features/courses/CoursesTable";

function Courses(){

    const [showCreateForm,setShowCreateForm] = useState(false);

    return (
        <div className="flex flex-col gap-6">
            <h2 className="text-4xl">All courses</h2>
            <CoursesTable  />
            <Button onClick={()=> setShowCreateForm((show)=>!show)}>Add New Course</Button>
            { 
            showCreateForm && <CreateCoursesForm setShowCreateForm={setShowCreateForm} />
                }

    
                
        </div>
    )

}

export default Courses;