import { useMutation, useQueryClient } from "@tanstack/react-query"
import { deleteCourse } from "../../services/apiCourses";
import toast from "react-hot-toast";

export const useDeleteCourse = ()=>{
    const queryClient = useQueryClient();
    const {mutate:deleteCourses, isPending: isDeleting} = useMutation({
        mutationFn:deleteCourse,
        onSuccess:()=>{
            queryClient.invalidateQueries({
                queryKey: ['courses']
            })
            toast.success("Course Deleted Successfully");
        }
    })

    return {deleteCourses,isDeleting}

}