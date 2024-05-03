
import SemesterItem from "./SemesterItem";
import { useSemester } from "./useSemester";
import { useSemesterByCourse } from "./useSemesterByCourse";


// function SemestersTable({semesters,courseName}){

//     const [showCreateForm,setShowCreateForm] = useState(false);

//     return (
//         <div className="flex flex-col gap-6">
//         <div className="border-2 border-slate-200 bg-white" role="table">
//             <header className="flex justify-around uppercase bg-slate-200" role="header">
//             <div>Name</div>
//             <div>Edit</div>
//             <div>Delete</div>
//             <div>Add Subjects</div>
//             </header>

//             {
//                 semesters?.map((semester)=> <SemestersRows key={semester.id} semester={semester} courseName={courseName} />)
//             }

            
           

//         </div>
//         <Button onClick={()=> setShowCreateForm((show)=> !show)}>Add New Semester</Button>
//         {
//            showCreateForm && <CreateSemestersForm setShowCreateForm={setShowCreateForm} courseName={courseName} />
           
//         }

      
//         </div>
//     )
    

// }

function SemestersTable({semesters}){


    return(
        <div>
            <div className="border-2 border-slate-200 bg-white" role="table">
            <header className="grid grid-cols-4 justify-items-center gap-8  bg-slate-200 p-3 uppercase " role="header">
                <div>
                    Name
                </div>
                <div>
                    Edit
                </div>
                <div>
                    Delete
                </div>
                <div>Add Subject</div>
                </header>
                 {
                     semesters?.map((semester)=> <SemesterItem semester={semester} key={semester.id} />)
                    }
                    
                      
                    </div>
                   
            
                
            </div>
    
        )

}

export default SemestersTable;