import { useState } from "react";
import { getSubjectsBySemesterId } from "../../services/apiSemesters";
import SelectSubjects from "./SelectSubjects";
import toast from "react-hot-toast";

function SelectSemester({semester,courseName}){

    const [subjects,setSubjects] = useState([]);

    const onSemesterHandler = async()=> {
        const response = await getSubjectsBySemesterId(semester.id);
        if(response.length === 0){
            toast.error("No Subject Found, Add a Subject");
        }
        setSubjects(response);
    
    }

    return (
        <>
        <div>
        <li className="text-lg hover:bg-slate-100 hover:cursor-pointer p-2" onClick={()=>onSemesterHandler(semester.semesterName)}>{semester.semesterName}</li>
        </div>
           
          <div>
          {
                subjects?.length > 0 && subjects.map((subject)=> {
                    return <SelectSubjects subject={subject} key={subject.subjectCode} courseName={courseName} />
                }
            )
            }
          </div>
           

        </>
    )

}


export default SelectSemester;