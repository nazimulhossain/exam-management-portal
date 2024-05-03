import {useState} from "react";
import { MdEditDocument,MdDelete  } from "react-icons/md";
import CreateSemestersForm from "./CreateSemestersForm";
import { useDeleteSemester } from "./useDeleteSemester";
import { useNavigate } from "react-router-dom";


function SemestersRows({semester,courseName}){

    const [editForm,setEditForm] = useState(false);

    const {semesterName,id} = semester;

    const navigate = useNavigate();

    const {deleteSem} = useDeleteSemester();

    return (
        <div className="flex flex-col gap-6">
        <div className="flex justify-around">
        <div>{semesterName}</div>
        <button className="pl-4" onClick={()=>setEditForm((show)=> !show)}>
        <MdEditDocument size={25} />
        </button>
        <button onClick={()=> deleteSem(id)}>
        <MdDelete size={25} />
        </button>
        <button onClick={()=> navigate(`${id}`)}>Add</button>

    </div>

    {
        editForm && <CreateSemestersForm setEditForm={setEditForm} currentSemester={semester} courseName={courseName}/>
    }

    </div>
   
    )

}


export default SemestersRows;