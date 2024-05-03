import { useSubjects } from "./useSubjects";
import SubjectItem from "./SubjectItem";



function SubjectTable(){

    const {subjects} = useSubjects()


    return(
    <div>
        <div className="border-2 border-slate-200 bg-white" role="table">
        <header className="grid grid-cols-[0.5fr_0.5fr_1fr_auto_0.5fr] justify-items-center gap-8  bg-slate-200 p-3 uppercase " role="header">
            <div>
                Name
            </div>
            <div>
                Code
            </div>
            <div>
            Description
            </div>
            <div>
                Edit
            </div>
            <div>
                Delete
            </div>
            </header>
             {
                 subjects?.map((subject)=> <SubjectItem subject={subject} key={subject.subjectName} />)
                }
                
                  
                </div>
               
        
            
        </div>

    )

}

export default SubjectTable;