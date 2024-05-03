import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import Button from '../../ui/Button';
import { useCreateSemester } from './useCreateSemester';
import { useEditSemester } from './useEditSemester.js';
import { useCreateSemesterByCourse } from './useCreateSemesterByCourse.js';


function CreateSemestersForm({setShowCreateForm={},currentSemester={},setEditForm={},courseName}){

   const {createSemesterbyCourse} = useCreateSemesterByCourse();

   const {editSemester} = useEditSemester();

    const {id,...editValues} =  currentSemester;

    const isEditSession = Boolean(id);

    const onCancel=()=>{
        isEditSession ? setEditForm((show)=> !show) : setShowCreateForm((show)=>!show);
    }
        

            return (
                <Formik

                initialValues={isEditSession ? editValues : {semesterName:''}}
                    validationSchema={Yup.object({
                        semesterName: Yup.string().required('Required')
                    })} 
                    onSubmit={(values,actions)=>{
                        isEditSession ? editSemester({id,...values}):createSemesterbyCourse({courseName,...values});
                        actions.resetForm({
                            values: {
                                semesterName:''
                                
                            }
                        });

                        onCancel();
                        
                    }}
                >
                    <Form className="bg-white flex flex-col gap-6 p-8">
                        <div className="grid grid-cols-[0.5fr_1fr] items-center">

                        <label htmlFor="semesterName" className="text-md font-medium">Semester name</label>
                        <div>
                        <Field name="semesterName" type="text" className="focus:outline-none  border-2 border-slate-400" />
                        <ErrorMessage name="semesterName" />
                        </div>
                        </div>
                        <div className="flex gap-6 self-end">

                        <Button type="reset" onClick={onCancel}>Cancel</Button>
                        <Button type="submit">{isEditSession ? 'Update semester' : 'Add semester'}</Button>

                        </div>
                    </Form>
                </Formik>
                 )


}

export default CreateSemestersForm;