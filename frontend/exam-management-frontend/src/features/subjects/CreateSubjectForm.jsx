import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';

import Button from '../../ui/Button';
import { useCreateSubject } from './useCreateSubject';
import { useEditSubject } from './useEditSubject';

function CreateSubjectForm({currentSubject={},setShowCreateForm={},setEditForm={}}){

    const {createSubjectFn} = useCreateSubject();

    const {editSubject} = useEditSubject();

    const {id,...editValues} = currentSubject;


    const isEditSession = Boolean(id);

    const onCancel=()=>{
        isEditSession ? setEditForm((show)=> !show) : setShowCreateForm((show)=>!show);
            
    }

            return (
                <Formik

                    initialValues={isEditSession ? editValues : {subjectName:'',subjectCode:'',subjectDescription: ''}}
                    validationSchema={Yup.object({
                        subjectName: Yup.string().required('Required'),
                        subjectCode: Yup.string().required('Required'),
                        subjectDescription: Yup.string().required('Required')

                    })} 
                    onSubmit={(values,actions)=>{
                        isEditSession ? editSubject({id,...values}):createSubjectFn({...values});
                        actions.resetForm({
                            values: {
                                subjectName:'',
                                subjectCode:'',
                                subjectDescription:''
                                
                            }
                        });
                        // setShowCreateForm(false);
                        onCancel();
                        
                    }}
                >
                    <Form className="bg-white flex flex-col gap-6 p-8">
                        <div className="grid grid-cols-[0.5fr_1fr] items-center">

                        <label htmlFor="subjectName" className="text-md font-medium">Name</label>
                        <div>
                        <Field name="subjectName" type="text" className="focus:outline-none  border-2 border-slate-400" />
                        <ErrorMessage name="subjectName" />
                        </div>
                        </div>

                        <div className="grid grid-cols-[0.5fr_1fr] items-center">

                        <label htmlFor="subjectCode" className="text-md font-medium">Subject code</label>
                        <div>
                        <Field name="subjectCode" type="text" className="focus:outline-none  border-2 border-slate-400" />
                        <ErrorMessage name="subjectCode" />
                        </div>
                        </div>

                        <div className="grid grid-cols-[0.5fr_1fr] items-center justify-center">
                        <label htmlFor="subjectDescription" className="text-md font-medium">Description</label>
                        <div>

                        <Field name="subjectDescription" as="textarea"  className="focus:outline-none border-2 border-slate-400"   />
                        <ErrorMessage name="subjectDescription" />
                        </div>
                        </div>
                        <div className="flex gap-6 self-end">

                        <Button type="reset" onClick={onCancel}>Cancel</Button>
                        <Button type="submit">{isEditSession ? 'Update subject' : 'Add subject'}</Button>

                        </div>
                    </Form>
                </Formik>
                 )

}

export default CreateSubjectForm;