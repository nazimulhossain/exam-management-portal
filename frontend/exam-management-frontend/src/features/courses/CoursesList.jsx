import { useNavigate, useParams } from "react-router-dom";
import { useCourses } from "./useCourses";
import Button from "../../ui/Button";
import { useState } from "react";
import FormCheck from "./FormCheck";
import { addCourseToSemester } from "../../services/apiSemesters";
import toast from "react-hot-toast";

function CoursesList(){

    const [inputValue,setInputValue] = useState([]);
    const {courses} = useCourses();

    const {semesterId} = useParams();

    const navigate = useNavigate();


    const onChangeHandler=(e)=>{
        if(e.target.checked){

            setInputValue((previous)=> [...previous,e.target.value]);
        }
        else {
            setInputValue((prevoius)=> prevoius.filter((el)=> el !== e.target.value));

        }
    }

    const onSubmitHandler=(e)=>{
        e.preventDefault();
        const mappedCourseToSemester = async()=> {
            const response = await addCourseToSemester(semesterId,inputValue);
            
        
                toast.success("Courses added to Semester");
                navigate(-1);
            

        }

        mappedCourseToSemester();

    }

    

    return (
        
        <div className="flex flex-col gap-4">
            <h2 className="text-4xl mb-3">All Courses</h2>
            <form onSubmit={onSubmitHandler} className="border-2 border-slate-200 bg-white p-4 text-lg flex flex-col gap-2">
            {courses?.data.map((course)=> {
                const {courseName} = course;
                return (
                    <div key={course.courseId} className="flex gap-2 mb-6">
                     <FormCheck name={courseName} onChangeHandler={onChangeHandler} />
                    </div>
                    
                )    
})}
            <Button type="submit">Submit</Button>
            </form>

            
            
        
        </div>
    )

}


export default CoursesList;