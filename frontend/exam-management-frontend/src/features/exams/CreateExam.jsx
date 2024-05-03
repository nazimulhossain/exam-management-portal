import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import CreateExamForm from "./CreateExamForm";
import Button from "../../ui/Button";
import { getExamBySubjectCode } from "../../services/apiExams";
import ExamTable from "./ExamTable";

function CreateExam(){

    const [showCreateForm,setShowCreateForm] = useState(false);
    const [subjectExam,setSubjectExam] = useState();

    const {id} = useParams();

    useEffect(()=>{

        const getExam  = async()=>{

            const response = await getExamBySubjectCode(id);
            setSubjectExam(response);


        }

        getExam();

    },[id])

    return (
        <div>
            {
                subjectExam ? 
                
                <ExamTable exam={subjectExam} />
                
                :  <Button onClick={()=> setShowCreateForm((show)=> !show)}>Add New Exam</Button>
            }
       

        {showCreateForm &&  <CreateExamForm subjectCode = {id} setShowCreateForm={setShowCreateForm}/>}
       

       
    
        </div>
    )

}

export default CreateExam;