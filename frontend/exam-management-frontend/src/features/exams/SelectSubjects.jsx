import { useNavigate } from "react-router-dom";

const SelectSubjects = ({subject,courseName})=> {

    const navigate = useNavigate();


    const onClickHandler = ()=>{

    navigate(`${subject.subjectCode}`)



    }

    return (
        <div className="flex flex-col gap-3 border-2 bg-slate-300 p-4 ">
            <p onClick={onClickHandler} className="hover:cursor-pointer">
                {subject.subjectName}
            </p>

        </div>
    )

}


export default SelectSubjects;