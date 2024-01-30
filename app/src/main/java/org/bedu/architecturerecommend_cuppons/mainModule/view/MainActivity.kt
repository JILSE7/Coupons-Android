package org.bedu.architecturerecommend_cuppons.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import org.bedu.architecturerecommend_cuppons.BR
import org.bedu.architecturerecommend_cuppons.R
import org.bedu.architecturerecommend_cuppons.common.utils.hideKeyboard
import org.bedu.architecturerecommend_cuppons.database.entities.CouponsEntity
import org.bedu.architecturerecommend_cuppons.databinding.ActivityMainBinding
import org.bedu.architecturerecommend_cuppons.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /*private lateinit var mainViewModel: MainViewModel*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

        /*DATA BINDING INFLATE*/
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        setupViewModel()
        setupObservers()

        /*DESACTIVADO POR DATA BINDING*/
        /*setupButtons()*/
    }

    private fun setupViewModel() {
        /*DESACTIVADO POR DATA BINDING*/
        /*mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]*/

        val vm: MainViewModel by viewModels()

        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }

    private fun setupObservers() {
        /*DESACTIVADO POR DATA BINDING*/
        /*mainViewModel.getResult().observe(this) { coupon ->
            if(coupon == null ){
                binding.tilDescription.hint = getString(R.string.main_hint_description)
                binding.tilDescription.isEnabled = true
                binding.btnCreate.visibility = View.VISIBLE
                return@observe
            }

            binding.etDescription.setText(coupon.description)
            val status = getString(if (coupon.isActive) R.string.main_hint_active else R.string.main_hint_description)

            binding.tilDescription.hint = status
            binding.tilDescription.isEnabled = false
            binding.btnCreate.visibility = if (coupon.isActive) View.GONE else View.VISIBLE
        }*/

        /*mainViewModel.getSnackbarMsg().observe(this) { message ->
            Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()

        }*/


        binding.viewModel?.let {
            it.coupon.observe(this) { coupon ->
                binding.isActive = coupon != null && coupon.isActive
            }

            it.getSnackbarMsg().observe(this@MainActivity) { message ->
                Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
            }

            it.getHideKeyboard().observe(this@MainActivity) { isHide ->
                if (isHide) hideKeyboard(this@MainActivity, binding.root)

            }
        }

    }

    /*DESACTIVADO POR DATA BINDING*/
    /*private fun setupButtons() {
        binding.btnConsult.setOnClickListener {

            hideKeyboard(this, binding.root)

            mainViewModel.getCouponByCode(binding.etCoupon.text.toString())
        }

        binding.btnCreate.setOnClickListener {
            val coupon = CouponsEntity(
                code = binding.etCoupon.text.toString(),
                description = binding.etDescription.text.toString()
            )

            hideKeyboard(this, binding.root)
            mainViewModel.saveCoupon(coupon)
        }
    }*/
}