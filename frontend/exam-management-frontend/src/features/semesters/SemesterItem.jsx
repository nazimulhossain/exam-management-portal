import { useState } from "react";

import { MdEditDocument,MdDelete,MdAddCircle   } from "react-icons/md";
import { useDeleteSemester } from "./useDeleteSemester";
import CreateSemestersForm from "./CreateSemestersForm";
import { useNavigate } from "react-router-dom";

function SemesterItem({semester}){

    const[editForm,setEditForm] = useState(false);

    const {id,semesterName} = semester;

    const navigate = useNavigate();


    const {deleteSemester} = useDeleteSemester();


   const onEditCourse=()=>{
    setEditForm((show)=> !show);
   }


   const addSujects = ()=> {
    navigate(`/semesters/${id}/subjects`)
   }

    return (
        <>
       <div className="grid grid-cols-4 gap-4 items-center justify-items-center p-3 border-b-2">
            <h2>{semesterName}</h2>
            <button className="hover:cursor-pointer" onClick={onEditCourse}>
            <MdEditDocument size={25} />
            </button>    
            <button onClick={()=>deleteSemester(id)}><MdDelete size={25} /></button>
            <button onClick={addSujects}><MdAddCircle size={25} /></button>
        
       </div>
       

       {editForm && 
       <div className="border-2" >

       <CreateSemestersForm currentSemester={semester} setEditForm={setEditForm}  />
       </div>
}
       </>
    )

}


export default SemesterItem;