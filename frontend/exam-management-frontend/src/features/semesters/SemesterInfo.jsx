import { useEffect } from "react";
import { useParams } from "react-router-dom";
import { getSemesterById } from "../../services/apiSemesters";
import { useSubjects } from "../subjects/useSubjects";
import SubjectList from "../subjects/SubjectList";

function SemesterInfo() {

    const {id} = useParams();

    const {subjects} = useSubjects();

    useEffect(()=>{
        const getData = async()=> {
            const response = await getSemesterById(id);

        }

        getData();

    },[])



    return (
        <>
       
       {subjects?.length > 0 && <SubjectList subject={subjects} id={id}/>} 
       
        </>
    )

}

export default SemesterInfo;