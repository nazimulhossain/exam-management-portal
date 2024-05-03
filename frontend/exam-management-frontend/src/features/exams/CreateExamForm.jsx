import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import Button from '../../ui/Button';
import { createExamApi } from '../../services/apiExams';


function CreateExamForm({subjectCode={},setShowCreateForm={},setEditForm={}}){

    // const {createCourses} = useCreateCourse();

    // const {editCourse} = useEditCourse();

    // const {courseId,...editValues} =  currentCourse;

    // const isEditSession = Boolean(courseId);

    const onCancel=()=>{
        setShowCreateForm((show)=>!show);
        
        
        
    }

            return (
                <Formik

                    initialValues={{name:'',description:'',totalMarks: ''}}
                    validationSchema={Yup.object({
                        name: Yup.string().required('Required'),
                        description: Yup.string().required('Required'),
                        totalMarks: Yup.string().required('Required')

                    })} 
                    onSubmit={(values,actions)=>{
                        // isEditSession ? editCourse({courseId,...values}):createCourses({...values});
                        createExamApi({subjectCode,...values})
                        actions.resetForm({
                            values: {
                                name:'',
                                description:'',
                                totalMarks:''
                                
                            }
                        });
                        
                    }}
                >
                    <Form className="bg-white flex flex-col gap-6 p-8">
                        <div className="grid grid-cols-[0.5fr_1fr] items-center">

                        <label htmlFor="name" className="text-md font-medium">Name</label>
                        <div>
                        <Field name="name" type="text" className="focus:outline-none  border-2 border-slate-400" />
                        <ErrorMessage name="name" />
                        </div>
                        </div>

                        <div className="grid grid-cols-[0.5fr_1fr] items-center">

                        <label htmlFor="description" className="text-md font-medium">Description</label>
                        <div>
                        <Field name="description" type="text" className="focus:outline-none  border-2 border-slate-400" />
                        <ErrorMessage name="description" />
                        </div>
                        </div>

                        <div className="grid grid-cols-[0.5fr_1fr] items-center justify-center">
                        <label htmlFor="totalMarks" className="text-md font-medium">Total Marks</label>
                        <div>

                        <Field name="totalMarks" as="textarea"  className="focus:outline-none border-2 border-slate-400"   />
                        <ErrorMessage name="totalMarks" />
                        </div>
                        </div>
                        <div className="flex gap-6 self-end">

                        <Button type="reset" onClick={onCancel}>Cancel</Button>
                        <Button type="submit">Create Exam</Button>

                        </div>
                    </Form>
                </Formik>
                 )

}

export default CreateExamForm;