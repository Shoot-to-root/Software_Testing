#cython: language_level=3
import angr
from angrutils import *
import claripy
"""
proj = angr.Project("./give_me_password", load_options={'auto_load_libs':False})
main = proj.loader.main_object.get_symbol("main")
start_state = proj.factory.blank_state(addr=main.rebased_addr)
cfg = proj.analyses.CFGEmulated(fail_fast=True, starts=[main.rebased_addr], initial_state=start_state)
plot_cfg(cfg, "cfg", asminst=True, remove_imports=True, remove_path_terminator=True)  
"""
project = angr.Project("./give_me_password")
initial_state = project.factory.entry_state(add_options=angr.options.unicorn)
sm = project.factory.simulation_manager(initial_state)
sm.explore(find=0x4009d7)
found = sm.found[0]
print(found.posix.dumps(0))

