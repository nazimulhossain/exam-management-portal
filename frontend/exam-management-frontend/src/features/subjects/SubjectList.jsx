import { useNavigate, useParams } from "react-router-dom";
import Button from "../../ui/Button";
import { useState } from "react";
import { addCourseToSemester, addSubjectsToSemester } from "../../services/apiSemesters";
import toast from "react-hot-toast";
import { useSubjects } from "./useSubjects";
import FormCheck from "../courses/FormCheck";


function SubjectList(){
  const [inputValue,setInputValue] = useState([]);
    const {subjects} = useSubjects();

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
        
        const mappedSubjectToSemester = async()=> {
          
            const response = await addSubjectsToSemester(semesterId,inputValue);
            
        
                toast.success("Subjects added to Semester");
                navigate(-1);
            

        }

        mappedSubjectToSemester();

    }

    

    return (
        
        <div className="flex flex-col gap-4">
            <h2 className="text-4xl mb-3">All Subjects</h2>
            <form onSubmit={onSubmitHandler} className="border-2 border-slate-200 bg-white p-4 text-lg flex flex-col gap-2">
            {subjects?.map((subject)=> {
              const {subjectName} = subject;
                return (
                    <div key={subject.id} className="flex gap-2 mb-6">
                     <FormCheck name={subjectName} onChangeHandler={onChangeHandler} />
                    </div>
                    
                )    
})}
            <Button type="submit">Submit</Button>
            </form>

            
            
        
        </div>
    )


}
export default SubjectList;