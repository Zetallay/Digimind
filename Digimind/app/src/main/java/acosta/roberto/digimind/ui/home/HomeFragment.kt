package acosta.roberto.digimind.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import acosta.roberto.digimind.R
import acosta.roberto.digimind.ui.Cuadro
import android.content.Context
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.celda.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    private var adaptador: AdaptadorTareas? = null


    companion object{
        var tasks = ArrayList<Cuadro>()
        var first = true
    }
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        if(first){
            fillTasks()
            first = false
        }


        adaptador = AdaptadorTareas(root.context, tasks)
        root.horarios.adapter = adaptador

        return root
    }

    fun fillTasks(){
        tasks.add(Cuadro("Practice 1", arrayListOf("Tuesday"),"17:00"))
        tasks.add(Cuadro("Practice 2",arrayListOf("Monday","Sunday"),"17:00"))
        tasks.add(Cuadro("Practice 3",arrayListOf("Wednesday"),"17:00"))
        tasks.add(Cuadro("Practice 4",arrayListOf("Saturday"),"17:00"))
        tasks.add(Cuadro("Practice 5",arrayListOf("Friday"),"17:00"))
        tasks.add(Cuadro("Practice 6",arrayListOf("Thursday"),"17:00"))
        tasks.add(Cuadro("Practice 7",arrayListOf("Monday"),"17:00"))
    }

    class AdaptadorTareas: BaseAdapter {
        var context: Context? =null
        var tasks = ArrayList<Cuadro>()

        constructor(context: Context, tasks: ArrayList<Cuadro>){
            this.context = context
            this.tasks = tasks
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var cuadro = tasks[p0]
            var inflator = LayoutInflater.from(context)
            var vista = inflator.inflate(R.layout.celda, null)

            vista.title.setText(cuadro.title)
            vista.tv_time.setText(cuadro.time)
            vista.tv_days.setText(cuadro.days.toString())

            return vista

        }

        override fun getItem(p0: Int): Any {
            return tasks[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 1
        }

        override fun getCount(): Int {
            return tasks.size
        }

    }
    }




