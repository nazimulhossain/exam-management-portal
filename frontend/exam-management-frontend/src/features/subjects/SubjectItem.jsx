import { MdEditDocument,MdDelete  } from "react-icons/md";
import { useState } from "react";
import CreateSubjectForm from "./CreateSubjectForm";
import {useDeleteSubject} from "./useDeleteSubject";

function SubjectItem({subject}){

    const[editForm,setEditForm] = useState(false);

    const {id,subjectName,subjectDescription,subjectCode} = subject;


    const {deleteSubject} = useDeleteSubject();


   const onEditCourse=()=>{
    setEditForm((show)=> !show);
   }

    return (
        <>
       <div className="grid grid-cols-[0.5fr_0.5fr_1fr_auto_0.5fr] gap-4 items-center justify-items-center p-3 border-b-2">
            <h2>{subjectName}</h2>
            <h2 className="uppercase">{subjectCode}</h2>
            <p>{subjectDescription}</p>
            <button className="hover:cursor-pointer" onClick={onEditCourse}>
            <MdEditDocument size={25} />
            </button>    
            <button onClick={()=>deleteSubject(id)}><MdDelete size={25} /></button>
        
       </div>
       

       {editForm && 
       <div className="border-2" >

       <CreateSubjectForm currentSubject={subject} setEditForm={setEditForm}  />
       </div>
}
       </>
    )

}

export default SubjectItem;