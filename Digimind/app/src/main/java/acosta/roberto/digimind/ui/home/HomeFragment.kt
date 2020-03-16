package acosta.roberto.digimind.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import acosta.roberto.digimind.R
import acosta.roberto.digimind.ui.Cuadro
import android.content.Context
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.celda.view.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView (


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        super.onCreate(savedInstanceState)





        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })


        return root
    }
}
    class HomeFragment2 : AppCompatActivity(){
        var adapter:CuadroAdapter? = null
        var cuadros = ArrayList<Cuadro>()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_home)
            adapter = CuadroAdapter(this,cuadros)
            cargarCuadros()
            horarios.adapter = adapter
        }

        fun cargarCuadros(){
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
            cuadros.add(Cuadro("Practice","Everyday","17:00"))
        }


        class CuadroAdapter: BaseAdapter {
            var context: Context? =null
            var cuadros = ArrayList<Cuadro>()

            constructor(context: Context, cuadros: ArrayList<Cuadro>){
                this.context = context
                this.cuadros = cuadros
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                var cuadro = cuadros[position]
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var vista = inflator.inflate(R.layout.celda, null)
                vista.practice.setText(cuadro.practice)
                vista.day.setText(cuadro.dia)
                vista.time.setText(cuadro.hora)

                return vista

            }

            override fun getItem(position: Int): Any {
                return 1
            }

            override fun getItemId(position: Int): Long {
                return 1
            }

            override fun getCount(): Int {
                return cuadros.size
            }

        }

    }




