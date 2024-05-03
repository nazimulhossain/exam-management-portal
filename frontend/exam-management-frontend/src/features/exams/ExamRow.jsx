import { MdEditDocument,MdDelete  } from "react-icons/md";
import { useState } from "react";
import { deleteExamApi } from "../../services/apiExams";

function ExamRow({exam}){

    const[editForm,setEditForm] = useState(false);

    const {id,name,description,totalMarks} = exam;

   const onEditCourse=()=>{
    setEditForm((show)=> !show);
   }

    return (
        <>
       <div className="grid grid-cols-[0.5fr_1fr_0.5fr_0.5fr_0.5fr]  p-2 border-b-2 justify-items-center items-center">
            <h2>{name}</h2>
            <p>{description}</p>
            <p>{totalMarks}</p>
            <button className="hover:cursor-pointer" onClick={onEditCourse}>
            <MdEditDocument size={25} />
            </button>
            
            <button onClick={()=> deleteExamApi(id)}><MdDelete size={25} /></button>
       </div>
       

       {/* {editForm && 
       <div className="border-2" >

       <CreateMcqsForm mcq={mcq} setEditForm={setEditForm} examName={examName} />
       </div> */}

       </>
    )

}

export default ExamRow;